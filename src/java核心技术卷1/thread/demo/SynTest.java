package java核心技术卷1. thread.demo;

/**
 * @Author wlc
 * @Date 2019-11-13 22:59
 */
public class SynTest implements Runnable {
    static SynTest instance = new SynTest();
    static int num = 0;

    @Override
    public void run() {
        //省略其他耗时操作。。。
        //使用同步代码块对变量i进行同步操作，锁对象为instance
        synchronized (instance) {
            for (int i = 0; i < 10000; i++) {
                num++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(num);
    }
}
