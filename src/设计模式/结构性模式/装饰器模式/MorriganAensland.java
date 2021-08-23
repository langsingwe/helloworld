package 设计模式.结构性模式.装饰器模式;

import javax.swing.*;
import java.awt.*;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MorriganAensland
 * @date 2021.08.14
 */
interface Morrigan {
    void display();
}

class Original extends JFrame implements Morrigan {
    private String image = "Morrigan0.jpg";
    public Original() {
        super("莫莉卡·安斯兰");
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public void display() {
        this.setLayout(new FlowLayout());
        JLabel jl = new JLabel(new ImageIcon("img/" + image));
        this.add(jl);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Changer implements Morrigan {
    Morrigan m;
    public Changer(Morrigan m) {
        this.m = m;
    }
    @Override
    public void display() {
        m.display();
    }
}

class Succubus extends Changer {
    public Succubus(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        setChange();
        super.display();
    }

    public void setChange() {
        ((Original) super.m).setImage("Morrigan1.jpg");
    }
}

class Girl extends Changer {

    public Girl(Morrigan m) {
        super(m);
    }

    @Override
    public void display() {
        setChanger();
        super.display();
    }
    public void setChanger() {
        ((Original) super.m).setImage("Morrigan2.jpg");
    }
}
public class MorriganAensland {
    public static void main(String[] args) {
        Original m0 = new Original();
        m0.display();
        Succubus m1 = new Succubus(m0);
        m1.display();
        Girl m2 = new Girl(m0);
        m2.display();
    }
}
