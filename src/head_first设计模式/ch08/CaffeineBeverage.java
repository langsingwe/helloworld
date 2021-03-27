package head_first设计模式.ch08;

/**
 * @Description
 * @ClassName CaffeineBeverage
 * @Author weilc
 * @Date 2021-01-21
 * @Version 1.0
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pour Into Cup");
    }
}
