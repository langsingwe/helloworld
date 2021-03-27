package head_first设计模式.ch03;

/**
 * @Description
 * @ClassName Espresso
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}
