package java核心技术卷1. thread.demo;

/**
 * @Author wlc
 * @Date 2019-11-13 22:14
 */
public class SynchronizedTest {
    static int num = 0;

    public static synchronized void add() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }

    public static class T extends Thread {
        @Override
        public void run() {
            SynchronizedTest.add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(SynchronizedTest.num);
    }
}
