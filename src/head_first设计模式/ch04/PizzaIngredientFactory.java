package head_first设计模式.ch04;

/**
 * @Description
 * @ClassName PizzaIngredientFactory
 * @Author weilc
 * @Date 2020-12-27
 * @Version 1.0
 */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
