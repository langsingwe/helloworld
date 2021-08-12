package 设计模式.创建型模式.抽象工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MacFactory
 * @date 2021.08.11
 */
public class MacFactory implements GUIFactory {
    @Override
    public Button createBtn() {
        return new MacBtn();
    }

    @Override
    public Text createText() {
        return new MacText();
    }
}
