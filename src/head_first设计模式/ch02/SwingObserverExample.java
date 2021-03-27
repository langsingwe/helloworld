package head_first设计模式.ch02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description
 * @ClassName SwingObserverExample
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class SwingObserverExample {
    JFrame jFrame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        jFrame = new JFrame();

        JButton jButton = new JButton("should I do it?");
        jButton.addActionListener(new AngelListener());
        jButton.addActionListener(new DevilListener());
        jFrame.getContentPane().add(BorderLayout.CENTER, jButton);
        jFrame.setVisible(true);
    }

    class AngelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("I'm Angel, don't do it, you might regret it");
        }
    }
    class DevilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on ,do it!");
        }
    }
}
