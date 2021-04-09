package java并发编程之美.ch10;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className CycleBarrierTest2
 * @date 2021.04.08
 */
public class CycleBarrierTest2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            try {
                System.out.println(Thread.currentThread() + " step1");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.submit(()->{
            try {
                System.out.println(Thread.currentThread() + " step1");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
