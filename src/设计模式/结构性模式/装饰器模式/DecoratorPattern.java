package 设计模式.结构性模式.装饰器模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className DecoratorPattern
 * @date 2021.08.13
 */
//抽象构件角色
interface Component {
    public void operation();
}

//具体构件
class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("创建具体构件角色");
    }

    @Override
    public void operation() {
        System.out.println("具体构件的 operation 方法");
    }
}

//抽象装饰角色
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this. component = component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}

//具体装饰者角色
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addExdFunc();
    }

    public void addExdFunc() {
        System.out.println("为具体构件角色增加额外的功能 addExdFunc()");
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        new ConcreteDecorator(new ConcreteComponent()).operation();
    }
}
