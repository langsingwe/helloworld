package head_first设计模式.ch07;

/**
 * @Description
 * @ClassName WildTurkey
 * @Author weilc
 * @Date 2021-01-17
 * @Version 1.0
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("fly a short distance");
    }
}
