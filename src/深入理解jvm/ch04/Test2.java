package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author weilc
 * @description
 * @className Test2
 * @date 2020-08-03
 */
public class Test2 {
    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            for (; ; ) {
            }
        }, "testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
