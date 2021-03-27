package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName FlyWithWings
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("鸭子用翅膀飞");
    }
}
