package head_first设计模式.ch08;

import java.applet.Applet;
import java.awt.*;

/**
 * @Description
 * @ClassName MyApplet
 * @Author weilc
 * @Date 2021-01-21
 * @Version 1.0
 */
public class MyApplet extends Applet {
    String msg;

    @Override
    public void init() {
        msg = "Hello world, i'm alive!";
        repaint();
    }

    @Override
    public void start(){
        msg = "now im starting up...";
        repaint();
    }

    @Override
    public void stop() {
        msg = "oh, im being stopped...";
        repaint();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawString(msg, 5, 15);
    }
}
