package java核心技术.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Bounce
 * @date 2021.03.11
 */
public class Bounce {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame jFrame = new BounceFrame();
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
    }

    static class BounceFrame extends JFrame {
        private BallComponent comp;
        public static final int STEPS = 1000;
        public static final int DELAY = 3;

        public BounceFrame() {
            setTitle("Bounce");
            comp = new BallComponent();
            add(comp, BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            addBtn(buttonPanel,"Start",event->addBall());
            addBtn(buttonPanel,"Close",event->System.exit(0));
            add(buttonPanel, BorderLayout.SOUTH);
            pack();
        }

        public void addBtn(Container c, String title, ActionListener listener) {
            JButton button = new JButton(title);
            c.add(button);
            button.addActionListener(listener);
        }

        public void addBall() {
            try {
                Ball ball = new Ball();
                comp.add(ball);
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (Exception e) {

            }
        }
    }


}
