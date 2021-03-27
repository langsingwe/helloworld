package head_first设计模式.ch12;

/**
 * @Description
 * @ClassName GooseAdapter
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class GooseAdapter implements Quackable {

    Observable observable;
    Goose goose;

    public GooseAdapter() {
        observable = new Observable(this);
    }

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
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
