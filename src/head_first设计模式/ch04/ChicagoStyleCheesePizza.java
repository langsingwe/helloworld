package head_first设计模式.ch04;

/**
 * @Description
 * @ClassName NYStyleCheesePizza
 * @Author weilc
 * @Date 2020-12-17
 * @Version 1.0
 */
public class ChicagoStyleCheesePizza extends Pizza {


    @Override
    void prepare() {

    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
