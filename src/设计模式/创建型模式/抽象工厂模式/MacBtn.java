package 设计模式.创建型模式.抽象工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MacBtn
 * @date 2021.08.11
 */
public class MacBtn implements Button {
    @Override
    public void paint() {
        System.out.println("macOS的button绘画");
    }
}
