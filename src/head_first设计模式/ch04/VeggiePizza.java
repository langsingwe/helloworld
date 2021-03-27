package head_first设计模式.ch04;

/**
 * @Description
 * @ClassName VeggiePizza
 * @Author weilc
 * @Date 2020-12-14
 * @Version 1.0
 */
public class VeggiePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);

    }
}
