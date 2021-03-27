package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName Main
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class TestMain {

    public static void main(String[] args) {
//        m1();
        m2();
    }

    static void m1() {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }

    static void m2() {
        ModelDuck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
        modelDuck.performQuack();
    }
}
