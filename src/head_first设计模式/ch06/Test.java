package head_first设计模式.ch06;

/**
 * @Description
 * @ClassName Testt
 * @Author weilc
 * @Date 2021-01-17
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();
    }
}
