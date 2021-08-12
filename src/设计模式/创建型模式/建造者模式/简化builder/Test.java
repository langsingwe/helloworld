package 设计模式.创建型模式.建造者模式.简化builder;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.08.12
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("intel", "三星")
                .setDisplay("TCL")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer.toString());
    }
}
