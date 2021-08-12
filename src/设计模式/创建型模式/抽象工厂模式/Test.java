package 设计模式.创建型模式.抽象工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.08.11
 */
public class Test {
    public static void main(String[] args) {
        GUIFactory factory = null;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacFactory();
        } else if (osName.contains("windows")) {
            factory = new WinFactory();
        }
        Application app = new Application(factory);
        app.paint();
    }
}
