package head_first设计模式.ch10;

/**
 * @Description
 * @ClassName SoldOutState
 * @Author weilc
 * @Date 2021-01-25
 * @Version 1.0
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you cant insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you cant eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}
