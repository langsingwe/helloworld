package 设计模式.创建型模式.建造者模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.08.12
 */
public class Test {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        AbstractComputerBuilder macComputerBuilder  = new MacComputerBuilder("i7", "三星125");
        director.makeComputer(macComputerBuilder);
        Computer mac = macComputerBuilder.getComputer();
        System.out.println("mac: " + mac.toString());

        AbstractComputerBuilder lenovoComputerBuilder  = new LenovoComputerBuilder("i5", "海力处理器");
        director.makeComputer(lenovoComputerBuilder);
        Computer lenovo = lenovoComputerBuilder.getComputer();
        System.out.println("lenovo: " + lenovo.toString());
    }
}
