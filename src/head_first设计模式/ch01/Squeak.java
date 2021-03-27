package head_first设计模式.ch01;

/**
 * @Description
 * @ClassName Squeak
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子吱吱叫");
    }
}
