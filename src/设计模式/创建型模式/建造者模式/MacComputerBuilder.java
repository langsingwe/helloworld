package 设计模式.创建型模式.建造者模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MacComputerBuilder
 * @date 2021.08.12
 */
public class MacComputerBuilder extends AbstractComputerBuilder {
    private Computer computer;

    public MacComputerBuilder(String cpu, String ram) {
        computer = new Computer(cpu, ram);
    }
    @Override
    public void setUsbCount() {
        computer.setUsbCount(2);
    }

    @Override
    public void setKeyboard() {
        computer.setKeyboard("苹果键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("苹果显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
