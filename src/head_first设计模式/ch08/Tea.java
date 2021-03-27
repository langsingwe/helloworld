package head_first设计模式.ch08;

/**
 * @Description
 * @ClassName Tea
 * @Author weilc
 * @Date 2021-01-21
 * @Version 1.0
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Stepping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
