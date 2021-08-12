package 设计模式.创建型模式.单例模式;

/**
 * @author weilc
 * @version 1.0
 * @description 饿汉式
 * @className HungrySingleton
 * @date 2021.08.10
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
