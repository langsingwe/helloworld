package head_first设计模式.ch08;

import javax.swing.*;
import java.awt.*;

/**
 * @Description
 * @ClassName MyFrame
 * @Author weilc
 * @Date 2021-01-21
 * @Version 1.0
 */
public class MyFrame extends JFrame {
    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String msg = "I rule!!";
        g.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head first Design patterns");
    }
}
