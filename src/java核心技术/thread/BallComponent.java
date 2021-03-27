package java核心技术.thread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className BallComponent
 * @date 2021.03.11
 */
public class BallComponent extends JPanel {

    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;

    List<Ball> balls = new ArrayList<>();

    public void add(Ball ball) {
        balls.add(ball);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball ball : balls) {
            g2.fill(ball.getShape());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
