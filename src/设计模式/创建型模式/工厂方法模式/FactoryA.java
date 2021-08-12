package 设计模式.创建型模式.工厂方法模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className FactoryA
 * @date 2021.08.11
 */
public class FactoryA implements Factory {
    @Override
    public Product product() {
        System.out.println("A工厂正在生产A...");
        return new ProductA();
    }
}
