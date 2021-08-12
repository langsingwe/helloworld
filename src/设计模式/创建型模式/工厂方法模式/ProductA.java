package 设计模式.创建型模式.工厂方法模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ProductA
 * @date 2021.08.11
 */
public class ProductA implements Product {
    @Override
    public void show() {
        System.out.println("这是A产品...");
    }
}
