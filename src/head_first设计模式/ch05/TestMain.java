package head_first设计模式.ch05;

/**
 * @Description
 * @ClassName TestMain
 * @Author weilc
 * @Date 2020-12-29
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            Singleton singleton1 = Singleton.getInstance();
            System.out.println(singleton1.toString());
        });
        thread1.start();
        Thread thread2 = new Thread(()->{
            Singleton singleton2 = Singleton.getInstance();
            System.out.println(singleton2.toString());
        });
        thread2.start();
    }
}
