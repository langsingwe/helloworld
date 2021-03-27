package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName ModelDuck
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class ModelDuck extends Duck {
    @Override
    public void display() {
        System.out.println("我是模型鸭");
    }
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
}
