package head_first设计模式.ch04;

/**
 * @Description
 * @ClassName SimplePizzaFactory
 * @Author weilc
 * @Date 2020-12-14
 * @Version 1.0
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
//        if ("cheese".equals(type)) {
//            pizza = new CheesePizza();
//        } else if ("pepperoni".equals(type)) {
//            pizza = new PepperoniPizza();
//        } else if ("clam".equals(type)) {
//            pizza = new ClamPizza();
//        } else if ("veggie".equals(type)) {
//            pizza = new VeggiePizza();
//        }
        return pizza;
    }
}
