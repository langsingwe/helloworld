package 设计模式.创建型模式.工厂方法模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Client
 * @date 2021.08.11
 */
public class Client {
    public static void main(String[] args) {
        new FactoryA().product().show();
        new FactoryB().product().show();
    }
}
