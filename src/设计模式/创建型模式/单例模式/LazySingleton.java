package 设计模式.创建型模式.单例模式;


/**
 * @author weilc
 * @version 1.0
 * @description 懒汉式单例模式，只有当第一次调用getInstance才实例化
 * @className Singleton
 * @date 2021.08.10
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
