package head_first设计模式.ch11;

import head_first设计模式.ch10.GumballMachine;

/**
 * @Description
 * @ClassName Testt
 * @Author weilc
 * @Date 2021-01-25
 * @Version 1.0
 */
public class Testt {
    public static void main(String[] args) {
        int count = 0;
        if (args.length < 2) {
            System.out.println("GumsballMachine <name> <inventory>");
            System.exit(1);
        }
        count = Integer.parseInt(args[1]);
        GumballMachine gumballMachine = new GumballMachine(args[0], count);
        GumballMonitor monitor = new GumballMonitor(gumballMachine);

        monitor.report();
    }
}
