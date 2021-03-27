package java核心技术.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @ClassName ThreadTest
 * @Author weilc
 * @Date 2020-11-12
 * @Version 1.0
 */
public class ThreadTest {
    static List<Thread> threads = new ArrayList<>();
    static int threadSize = 3;
    static int threadIndex = 0;
    static int maxValue = 100;
    static int curValue = 1;

    public static void main(String[] args) {
//        m1();
        m2();
    }

    static void m1() {
        AtomicLong atomicLong = new AtomicLong();
        long id = atomicLong.incrementAndGet();
        System.out.println(id);
    }

    static void m2() {
        for (int i = 1; i <= threadSize; i++) {
            Thread thread = new Thread(()->{
                while (true) {
                    LockSupport.park();
                    if (curValue <= maxValue) {
                        System.out.println(Thread.currentThread().getName() + ":" + curValue++);
                    } else {
                        break;
                    }
                    LockSupport.unpark(threads.get(++threadIndex % threads.size()));
                }
                threads.forEach(LockSupport::unpark);
            });
            thread.setName(String.format("Thread-%d", i));
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        LockSupport.unpark(threads.get(0));
    }
}
