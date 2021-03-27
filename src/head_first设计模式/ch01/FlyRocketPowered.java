package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName FlyRockePowered
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("火箭动力飞行");
    }
}
