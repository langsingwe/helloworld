package head_first设计模式.ch03;

/**
 * @Description
 * @ClassName Beverage
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public abstract class Beverage {
    String description = "unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
