package 设计模式.创建型模式.建造者模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ComputerBuilder
 * @date 2021.08.12
 */
public abstract class AbstractComputerBuilder {
    public abstract void setUsbCount();
    public abstract void setKeyboard();
    public abstract void setDisplay();

    public abstract Computer getComputer();
}
