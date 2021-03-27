package head_first设计模式.ch04;

/**
 * @Description
 * @ClassName PizzaStore
 * @Author weilc
 * @Date 2020-12-14
 * @Version 1.0
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        return pizza;
    }

    abstract Pizza createPizza(String type);
}
