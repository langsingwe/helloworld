package head_first设计模式.ch12;

import javax.swing.*;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className BeatBar
 * @date 2021.01.30
 */
public class BeatBar extends JPanel {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
