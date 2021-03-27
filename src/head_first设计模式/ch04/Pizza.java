package head_first设计模式.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @ClassName Pizza
 * @Author weilc
 * @Date 2020-12-14
 * @Version 1.0
 */
public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;
    List toppings = new ArrayList();

    abstract void prepare();

    void bake() {
        System.out.println("bake");
    }

    void cut() {
        System.out.println("cut");
    }

    void box() {
        System.out.println("box");
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                ", toppings=" + toppings +
                '}';
    }
}
