package head_first设计模式.ch06;

/**
 * @Description
 * @ClassName SimpleRemoteControl
 * @Author weilc
 * @Date 2021-01-17
 * @Version 1.0
 */
public class SimpleRemoteControl {
    Command command;

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
    }
}
