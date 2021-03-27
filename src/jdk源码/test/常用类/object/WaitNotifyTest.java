package test.常用类.object;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className WaitNotifyTest
 * @date 2021.03.18
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(()->{
            System.out.println("线程A等待获取lock锁");
            synchronized (lock) {
                try {
                    System.out.println("线程A获取到了lock锁");
                    Thread.sleep(1000);
                    System.out.println("线程A即将运行wait()方法进行等待");
                    lock.wait();
                    System.out.println("线程A等待结束");
                } catch (InterruptedException e) {

                }
            }
        }).start();

        new Thread(()->{
            System.out.println("线程B等待获取lock锁");
            synchronized (lock) {
                System.out.println("线程B获取到了lock锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("线程B要运行Notify()进行通知");
                lock.notify();
            }
        }).start();
    }
}
