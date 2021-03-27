package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName MallardDuck
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class MallardDuck extends Duck {
    public MallardDuck () {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭");
    }


}
