package 设计模式.创建型模式.抽象工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className GUIFactory
 * @date 2021.08.11
 */
public interface GUIFactory {
    Button createBtn();
    Text createText();
}
