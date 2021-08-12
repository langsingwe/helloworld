package 设计模式.创建型模式.单例模式;

/**
 * @author weilc
 * @version 1.0
 * @description 线程安全的单例模式
 * @className SyncSingleton
 * @date 2021.08.10
 */
public class SyncSingleton {

    private static volatile SyncSingleton instance;

    private SyncSingleton() {}

    public static SyncSingleton getInstance() {
        if (instance == null) {
            synchronized (SyncSingleton.class) {
                if (instance == null) {
                    instance = new SyncSingleton();
                }
            }
        }
        return instance;
    }

}
