package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author wlc
 * @Date 2019-11-18 23:15
 */
public class LockSupportTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start");
            System.out.println(Thread.currentThread().getName() + ",park()之前中断标志：" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + ",park()之后中断标志：" + Thread.currentThread().isInterrupted());
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒");
        });
        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        t1.interrupt();
    }
}
