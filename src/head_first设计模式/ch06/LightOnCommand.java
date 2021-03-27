package head_first设计模式.ch06;

/**
 * @Description
 * @ClassName LightOnCommand
 * @Author weilc
 * @Date 2021-01-17
 * @Version 1.0
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
