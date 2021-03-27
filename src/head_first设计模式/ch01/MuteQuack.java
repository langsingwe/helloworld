package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName MuteQuack
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子不会叫");
    }
}
