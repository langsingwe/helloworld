package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName FlyNoWay
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞的鸭子");
    }
}
