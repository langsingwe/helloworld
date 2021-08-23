package 设计模式.行为型模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ObserverPattern
 * @date 2021.08.18
 */
//抽象观察者
interface Observer {
    void response();
}

//具体观察者1
class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}

//具体观察者2
class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}

//抽象主题
abstract class Subject {
    List<Observer> list = new ArrayList<>();

    public void add(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    //通知观察者方法
    public abstract void notifyObserver();
}

//具体主题
class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变");
        System.out.println("------------");

        for (Observer observer : list) {
            observer.response();
        }
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        ConcreteObserver1 observer1 = new ConcreteObserver1();
        ConcreteObserver2 observer2 = new ConcreteObserver2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();
    }
}
