package 设计模式.行为型模式.中介者模式;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className DatingPlatform
 * @date 2021.08.19
 */
interface Medium {
    void register(Customer customer);

    void relay(String from, String msg);
}

class EstateMedium implements Medium {
    private List<Customer> list = new ArrayList<>();

    @Override
    public void register(Customer customer) {
        if (!list.contains(customer)) {
            list.add(customer);
            customer.setMedium(this);
        }
    }

    @Override
    public void relay(String from, String msg) {
        for (Customer c : list) {
            String name = c.getName();
            if (!name.equals(from)) {
                c.receive(from, msg);
            }
        }
    }
}
abstract class Customer extends JFrame implements ActionListener {
    protected Medium medium;
    protected String name;
    JTextField sendText;
    JTextArea receiveArea;

    public Customer(String name) {
        super(name);
        this.name = name;
    }

    void clientWindow(int x, int y) {
        Container cp;
        JScrollPane sp;
        JPanel p1, p2;
        cp = this.getContentPane();
        sendText = new JTextField(18);
        receiveArea = new JTextArea(10, 18);
        receiveArea.setEditable(false);
        p1 = new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("接收内容："));
        p1.add(receiveArea);
        sp = new JScrollPane(p1);
        cp.add(sp, BorderLayout.NORTH);
        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("发送内容："));
        p2.add(sendText);
        cp.add(p2, BorderLayout.SOUTH);
        sendText.addActionListener(this);
        this.setLocation(x, y);
        this.setSize(250,330);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String tempInfo = sendText.getText().trim();
        sendText.setText("");
        this.send(tempInfo);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public abstract void send(String info);

    public abstract void receive(String from, String msg);
}

class Seller extends Customer {
    public Seller(String name) {
        super(name);
        clientWindow(50, 100);
    }
    @Override
    public void send(String info) {
        receiveArea.append("我(卖方)说：" + info + "\n");
        receiveArea.setCaretPosition(receiveArea.getText().length());
        medium.relay(name, info);
    }

    @Override
    public void receive(String from, String msg) {
        receiveArea.append(from + "说：" + msg + "\n");
        receiveArea.setCaretPosition(receiveArea.getText().length());
    }
}

class Buyer extends Customer {

    public Buyer(String name) {
        super(name);
        clientWindow(350, 100);
    }

    @Override
    public void send(String info) {
        receiveArea.append("我(买方)说: " + info + "\n");
        //使滚动条滚动到最底端
        receiveArea.setCaretPosition(receiveArea.getText().length());
        medium.relay(name, info);
    }

    @Override
    public void receive(String from, String msg) {
        receiveArea.append(from + "说: " + msg + "\n");
        //使滚动条滚动到最底端
        receiveArea.setCaretPosition(receiveArea.getText().length());
    }
}

public class DatingPlatform {
    public static void main(String[] args) {
        Medium md = new EstateMedium();    //房产中介
        Customer member1, member2;
        member1 = new Seller("张三(卖方)");
        member2 = new Buyer("李四(买方)");
        md.register(member1); //客户注册
        md.register(member2);
    }
}
