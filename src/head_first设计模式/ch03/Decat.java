package head_first设计模式.ch03;

/**
 * @Description
 * @ClassName HouseBlend
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class Decat extends Beverage {
    public Decat() {
        description = "De cat Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
