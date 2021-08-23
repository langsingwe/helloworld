package 设计模式.行为型模式.状态模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className StatePatternClient
 * @date 2021.08.18
 */
//抽象状态类
abstract class State  {
    abstract void handle(Context context);
}

//具体状态A类
class ConcreteStateA extends State  {

    @Override
    void handle(Context context) {
        System.out.println("当前状态是 A.");
        context.setState(new ConcreteStateB());
    }
}

//具体状态B类
class ConcreteStateB extends State {

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 B.");
        context.setState(new ConcreteStateA());
    }
}

//环境类
class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle() {
        state.handle(this);
    }
}

public class StatePatternClient {
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.handle();
        ctx.handle();
        ctx.handle();
    }
}
