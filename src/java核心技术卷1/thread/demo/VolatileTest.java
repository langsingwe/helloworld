package java核心技术卷1. thread.demo;

/**
 * @Author wlc
 * @Date 2019-11-12 22:08
 */
public class VolatileTest {
    public volatile static boolean flag = true;

    public static class T1 extends Thread {
        public T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("线程 " + this.getName() + " in");
            while (flag) {
            }
            System.out.println("线程 " + this.getName() + " 停止了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new T1("t1").start();
        Thread.sleep(1000);
        flag = false;
    }
}
