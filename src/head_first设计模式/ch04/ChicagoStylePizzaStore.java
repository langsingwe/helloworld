package head_first设计模式.ch04;

/**
 * @Description
 * @ClassName NYStylePizzaStore
 * @Author weilc
 * @Date 2020-12-17
 * @Version 1.0
 */
public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ChicagoStyleClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        }
        return pizza;
    }
}
