package 设计模式.创建型模式.工厂方法模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className FactoryB
 * @date 2021.08.11
 */
public class FactoryB implements Factory {
    @Override
    public Product product() {
        System.out.println("B工厂正在生产B...");
        return new ProductB();
    }
}
