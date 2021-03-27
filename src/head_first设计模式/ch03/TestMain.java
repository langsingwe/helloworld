package head_first设计模式.ch03;

/**
 * @Description
 * @ClassName TestMain
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class TestMain {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new Whip(new Mocha(new Soy(new HouseBlend())));
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
