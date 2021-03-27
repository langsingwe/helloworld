package head_first设计模式.ch12;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description
 * @ClassName Flock
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class Flock implements Quackable {
    ArrayList ducks = new ArrayList();

    public void add(Quackable quacker) {
        ducks.add(quacker);
    }

    @Override
    public void quack() {
        Iterator iterator = ducks.iterator();
        while (iterator.hasNext()) {
            Quackable duck = (Quackable) iterator.next();
            duck.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator iterator = ducks.iterator();
        while (iterator.hasNext()) {
            Quackable duck = (Quackable) iterator.next();
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {

    }
}
