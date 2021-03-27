package head_first设计模式.ch12;

/**
 * @Description
 * @ClassName MallardDuck
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class RedheadDuck implements Quackable {

    Observable observable;

    public RedheadDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
