package 设计模式.行为型模式.命令模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className CommandPattern
 * @date 2021.08.17
 */

//抽象命令
interface Command {
    void execute();
}

//接收者
class Receiver {
    public void action() {
        System.out.println("接收者的 action() 方法被调用");
    }
}

//具体命令
class ConcreteCommand implements Command {

    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

//调用者
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令 command ...");
        command.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        System.out.println("客户访问调用者的call方法...");
        invoker.call();
    }
}
