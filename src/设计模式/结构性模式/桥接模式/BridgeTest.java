package 设计模式.结构性模式.桥接模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className BridgeTest
 * @date 2021.08.13
 */
//实现化角色
interface Implementor {
    void OperationImpl();
}

//具体实现化角色
class ConcreteImplementorA implements  Implementor {

    @Override
    public void OperationImpl() {
        System.out.println("具体实现化 ConcreteImplementorA 被访问");
    }
}

//抽象化角色
abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public abstract void Operation();
}

//扩展抽象化角色
class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    @Override
    public void Operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        implementor.OperationImpl();
    }
}

public class BridgeTest {
    public static void main(String[] args) {
        ConcreteImplementorA implementor = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(implementor);
        abs.Operation();
    }
}
