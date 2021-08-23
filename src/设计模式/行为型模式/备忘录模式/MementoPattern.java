package 设计模式.行为型模式.备忘录模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MementoPattern
 * @date 2021.08.20
 */

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void resetMemento(Memento memento) {
        this.setState(memento.getState());
    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("S0");
        System.out.println("初始状态-------" + originator.getState());
        caretaker.setMemento(originator.createMemento());
        originator.setState("S1");
        System.out.println("新的状态-------" + originator.getState());
        originator.resetMemento(caretaker.getMemento());
        System.out.println("恢复状态-------" + originator.getState());
    }
}
