package head_first设计模式.ch05;

/**
 * @Description
 * @ClassName Singleton
 * @Author weilc
 * @Date 2020-12-29
 * @Version 1.0
 */
public class Singleton {

    private Singleton(){}

    private volatile static Singleton uniqueInstance;

    public static Singleton getInstance() {
        if (null == uniqueInstance) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
