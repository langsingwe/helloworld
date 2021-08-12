package 设计模式.创建型模式.建造者模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ComputerDirector
 * @date 2021.08.12
 */
public class ComputerDirector {
    public void makeComputer(AbstractComputerBuilder builder) {
        builder.setUsbCount();
        builder.setKeyboard();
        builder.setDisplay();
    }
}
