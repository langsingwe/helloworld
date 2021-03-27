package head_first设计模式.ch10;

/**
 * @Description
 * @ClassName NoQuarterState
 * @Author weilc
 * @Date 2021-01-25
 * @Version 1.0
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        gumballMachine.setState(gumballMachine.getHasQuarterState());
        System.out.println("you inserted a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you havent inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("you need to pay first");
    }
}
