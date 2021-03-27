package head_first设计模式.ch11;

import head_first设计模式.ch10.GumballMachine;

/**
 * @Description
 * @ClassName GumballMonitor
 * @Author weilc
 * @Date 2021-01-25
 * @Version 1.0
 */
public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println("Gumball Machine: " + machine.getLocation());
        System.out.println("Current inventory: " + machine.getCount() + " gumballs");
        System.out.println("Current state: " + machine.getState());
    }
}
