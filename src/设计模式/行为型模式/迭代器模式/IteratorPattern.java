package 设计模式.行为型模式.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className IteratorPattern
 * @date 2021.08.20
 */
interface Aggregate {
    void add(Object object);

    void remove(Object object);

    public Iterator getIterator();
}

class ConcreteAggregate implements  Aggregate {
    List<Object> list = new ArrayList<>();

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public void remove(Object object) {
        list.remove(object);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}

interface Iterator {
    Object first();

    Object next();

    boolean hasNext();
}

class ConcreteIterator implements Iterator {
    List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        Object o = list.get(index);
        return o;
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        }
        return false;
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add(1);
        ag.add(2);
        ag.add(3);
        System.out.print("聚合内容：");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object object = it.next();
            System.out.print(object.toString() + "\t");
        }
        Object first = it.first();
        System.out.println("\n first: " + first.toString());
    }
}
