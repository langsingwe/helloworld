package head_first设计模式.ch03;

/**
 * @Description
 * @ClassName Whip
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .50 + beverage.cost();
    }
}
