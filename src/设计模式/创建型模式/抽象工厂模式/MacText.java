package 设计模式.创建型模式.抽象工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MacText
 * @date 2021.08.11
 */
public class MacText implements Text {
    @Override
    public void paint() {
        System.out.println("mac的text绘画");
    }
}
