package 设计模式.行为型模式.模板方法;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className TemplateMethodPattern
 * @date 2021.08.16
 */
abstract class AbstractClass {
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用");
    }

    public abstract void abstractMethod1();

    public abstract void abstractMethod2();
}

class ConcreteClass extends AbstractClass {

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用");
    }
}
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.templateMethod();
    }
}
