package java核心技术卷1. thread.demo.calc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by weiliangchun on 2019/11/30
 */
public class Demo1 {
    static int count = 0;

    public static synchronized void incr() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            count = 0;
            m1();
        }
    }

    public static void m1() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        int threadCount = 50;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 1000000; j++) {
                        incr();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long t2 = System.currentTimeMillis();
        System.out.println("count = " + count + ";time = " + (t2 - t1));
    }
}
