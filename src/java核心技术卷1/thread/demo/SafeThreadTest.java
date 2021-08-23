package java核心技术卷1. thread.demo;

/**
 * @Author wlc
 * @Date 2019-11-13 21:56
 */
public class SafeThreadTest {
    static int num = 0;

    public static synchronized void m1() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            SafeThreadTest.m1();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T1 t2 = new T1();
        T1 t3 = new T1();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(SafeThreadTest.num);
    }
}
