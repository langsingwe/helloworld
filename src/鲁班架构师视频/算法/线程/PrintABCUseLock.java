package 算法.线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className PrintThreadInTurn
 * @date 2021.02.01
 */
public class PrintABCUseLock {

    private int times;
    private int state;

    private Lock lock = new ReentrantLock();

    public PrintABCUseLock(int times) {
        this.times = times;
    }

    void print(String str, int targetNum) {
        for (int i = 0; i < times;) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++;
                System.out.println(str);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABCUseLock foo = new PrintABCUseLock(3);
        new Thread(() -> {
            foo.print("A", 0);
        }).start();
        new Thread(() -> {
            foo.print("B", 1);
        }).start();
        new Thread(() -> {
            foo.print("C", 2);
        }).start();
    }
}
