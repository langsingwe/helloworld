package head_first设计模式.ch03;

/**
 * @Description
 * @ClassName Soy
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
