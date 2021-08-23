package 设计模式.行为型模式.策略模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className StrategyPattern
 * @date 2021.08.17
 */

//抽象策略类
interface Strategy {
    //策略方法
    void strategyMethod();
}

//具体策略类A
class ConcreteStrategyA implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("具体策略类A的策略方法被调用");
    }
}

//具体策略类B
class ConcreteStrategyB implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("具体策略类B的策略方法被调用");
    }
}

class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Context ctx = new Context();
        Strategy s = new ConcreteStrategyA();
        ctx.setStrategy(s);
        ctx.strategyMethod();
        System.out.println("----------------");
        s = new ConcreteStrategyB();
        ctx.setStrategy(s);
        ctx.strategyMethod();
    }
}
