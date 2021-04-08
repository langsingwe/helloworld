package java并发编程之美.ch11;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className JoinCountDownLatch
 * @date 2021.04.07
 */
public class JoinCountDownLatch {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("child t1 over");
        });
        executorService.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("child t2 over");
        });



        System.out.println("wait all child thread over");

        countDownLatch.await();

        System.out.println("all child thread over");

        executorService.shutdown();
    }
}
