package thread.demo;

import java.util.concurrent.TimeUnit;

/**
 * @Author wlc
 * @Date 2019-11-14 21:23
 */
public class ThreadInterruptTest {
    public static class T1 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.interrupt();
                }
                if (this.isInterrupted()) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        t1.interrupt();
    }
}
