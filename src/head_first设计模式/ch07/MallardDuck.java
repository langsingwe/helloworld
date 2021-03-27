package head_first设计模式.ch07;

/**
 * @Description
 * @ClassName MallardDuck
 * @Author weilc
 * @Date 2021-01-17
 * @Version 1.0
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("flying");
    }
}
