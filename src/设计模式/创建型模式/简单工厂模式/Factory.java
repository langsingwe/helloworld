package 设计模式.创建型模式.简单工厂模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Factory
 * @date 2021.08.10
 */
public class Factory {
    public static Animal getInstance(String type) {
        Animal animal = null;
        switch (type) {
            case "dog":
                animal = new Dog();
                break;
            case "cat":
                animal = new Cat();
                break;
        }
        return animal;
    }

    public static void main(String[] args) {
        Animal instance = Factory.getInstance("dog");
        instance.say();
    }
}
