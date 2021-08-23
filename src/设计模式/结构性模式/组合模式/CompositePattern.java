package 设计模式.结构性模式.组合模式;

import java.util.ArrayList;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className CompositePattern
 * @date 2021.08.16
 */

//抽象构件
interface Component {

    void operation();
}

//树叶构件
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void add(Component component) {

    }

    public void remove(Component component) {

    }

    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶 " + name + " 被访问！");
    }
}

//树枝构件
class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Composite c0 = new Composite();
        Composite c1 = new Composite();
        Leaf leaf1 = new Leaf("1");
        Leaf leaf2 = new Leaf("2");
        Leaf leaf3 = new Leaf("3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}
