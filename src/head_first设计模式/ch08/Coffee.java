package head_first设计模式.ch08;

/**
 * @Description
 * @ClassName Coffe
 * @Author weilc
 * @Date 2021-01-21
 * @Version 1.0
 */
public class Coffee  extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
