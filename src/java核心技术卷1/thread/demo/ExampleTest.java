package thread.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiliangchun on 2019/11/30
 */
public class ExampleTest {
    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                boolean flag = false;
                try {
                    flag = semaphore.tryAcquire(100, TimeUnit.MICROSECONDS);
                    if (flag) {
                        System.out.println(Thread.currentThread() + "尝试下单中....");
                        TimeUnit.SECONDS.sleep(2);
                    } else {
                        System.out.println(Thread.currentThread() + "秒杀失败，请重试......");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (flag) {
                        semaphore.release();
                    }
                }
            }).start();
        }
    }
}
