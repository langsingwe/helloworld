package head_first设计模式.ch03;

/**
 * @Description
 * @ClassName Mocha
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
