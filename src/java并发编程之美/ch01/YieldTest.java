package java并发编程之美.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className YieldTest
 * @date 2021.03.26
 */
public class YieldTest implements Runnable{

    public YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 5 == 0) {
                System.out.println(Thread.currentThread() + " yield cpu ...");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + " is over ...");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
