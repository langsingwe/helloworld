package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName Duck
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public abstract class Duck {
    QuackBehavior quackBehavior;
    public void performQuack() {
        quackBehavior.quack();
    }
    FlyBehavior flyBehavior;
    public void performFly() {
        flyBehavior.fly();
    }

    public Duck() {}

    public abstract void display();

    public void swim() {
        System.out.println("鸭子游泳");
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
