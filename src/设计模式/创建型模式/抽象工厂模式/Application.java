package 设计模式.创建型模式.抽象工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Application
 * @date 2021.08.11
 */
public class Application {
    private Button button;
    private Text text;

    public Application(GUIFactory factory) {
        button = factory.createBtn();
        text = factory.createText();
    }

    public void paint() {
        button.paint();
        text.paint();
    }
}
