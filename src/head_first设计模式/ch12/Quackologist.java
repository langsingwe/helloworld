package head_first设计模式.ch12;

/**
 * @Description
 * @ClassName Quackologist
 * @Author weilc
 * @Date 2021-01-30
 * @Version 1.0
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked");
    }
}
