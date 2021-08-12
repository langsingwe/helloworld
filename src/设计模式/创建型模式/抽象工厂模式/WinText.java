package 设计模式.创建型模式.抽象工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className WinText
 * @date 2021.08.11
 */
public class WinText implements Text {
    @Override
    public void paint() {
        System.out.println("windows的text绘画");
    }
}
