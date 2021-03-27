package head_first设计模式.ch11;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Description
 * @ClassName ImageProxy
 * @Author weilc
 * @Date 2021-01-28
 * @Version 1.0
 */
public class ImageProxy implements Icon {

    ImageIcon imageIcon;
    URL imageUrl;
    Thread retrievalThread;
    boolean retrieving = false;

    public ImageProxy(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
            if (!retrieving) {
                retrieving = true;
                retrievalThread = new Thread((() -> {
                    try {
                        imageIcon = new ImageIcon(imageUrl, "CD cover");
                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();;
                    }
                }));
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }
}
