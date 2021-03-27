package java并发编程之美.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className InterruptedTest2
 * @date 2021.03.27
 */
public class InterruptedTest2 {
    public static void main(String[] args) {
        Thread threadOne = new Thread(()->{
            for (; ; ) {

            }
        });
        threadOne.start();

        threadOne.interrupt();

        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        System.out.println("isInterrupted:" + threadOne.isInterrupted());
    }
}
