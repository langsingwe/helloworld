package head_first设计模式.ch04;

/**
 * @Description
 * @ClassName ChicagoPizzaStore
 * @Author weilc
 * @Date 2020-12-26
 * @Version 1.0
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new ChicagoStyleCheesePizza();
        } else if ("veggie".equals(type)) {
            return new ChicagoStyleVeggiePizza();
        } else if ("clam".equals(type)) {
            return new ChicagoStyleClamPizza();
        } else if ("pepperoni".equals(type)) {
            return new ChicagoStylePepperoniPizza();
        } else {
            return null;
        }
    }
}
