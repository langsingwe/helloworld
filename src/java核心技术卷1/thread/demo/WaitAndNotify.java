package thread.demo;

/**
 * @Author wlc
 * @Date 2019-11-12 20:19
 */
public class WaitAndNotify {
    static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T1 start");
                try {
                    System.out.println(System.currentTimeMillis() + " T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " T1 end");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T2 start notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + " T2 end");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " T1 end");
            }
        }
    }

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
    }
}
