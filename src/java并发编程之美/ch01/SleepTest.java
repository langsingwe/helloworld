package java并发编程之美.ch01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className SleepTest
 * @date 2021.03.26
 */
public class SleepTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("child threadA is in sleep");
                Thread.sleep(1000);
                System.out.println("child threadA is awaked");
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(()->{
            lock.lock();
            try {
                System.out.println("child threadB is in sleep");
                Thread.sleep(1000);
                System.out.println("child threadB is awaked");
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();
    }
}
