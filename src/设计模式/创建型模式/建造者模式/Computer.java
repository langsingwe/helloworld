package 设计模式.创建型模式.建造者模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Computer
 * @date 2021.08.12
 */
public class Computer {
    //必选
    private String cpu;
    //必选
    private String ram;
    //非必选
    private int  usbCount;
    //非必选
    private String keyboard;
    //非必选
    private String display;

    public Computer(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usbCount=" + usbCount +
                ", keyboard='" + keyboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
