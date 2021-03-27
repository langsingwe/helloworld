package java并发编程之美.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className InterruptedTest
 * @date 2021.03.26
 */
public class InterruptedTest {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(()->{
            try {
                System.out.println("thread begin sleep for 2000 seconds");
                Thread.sleep(2000000);
                System.out.println("thread awaking");
            } catch (InterruptedException e) {
                System.out.println("thread is interrupted while sleeping");
                return;
            }

            System.out.println("thread-leaving normally");
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println("main thread is over");
    }
}
