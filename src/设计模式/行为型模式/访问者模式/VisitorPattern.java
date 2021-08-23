package 设计模式.行为型模式.访问者模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className VisitorPattern
 * @date 2021.08.20
 */

interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问------>" + element.optA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问------>" + element.optB());
    }
}

class ConcreteVisitorB implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问------>" + element.optA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者B访问------>" + element.optB());
    }
}

interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String optA() {
        return "具体元素A的操作";
    }
}

class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String optB() {
        return "具体元素B的操作";
    }
}

class ObjectStructure {
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        Iterator<Element> it = list.iterator();
        while (it.hasNext()) {
            it.next().accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------");
        visitor = new ConcreteVisitorB();
        os.accept(visitor);
    }
}
