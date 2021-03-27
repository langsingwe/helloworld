package thread.demo;

import java.util.concurrent.TimeUnit;

/**
 * @Author wlc
 * @Date 2019-11-12 20:00
 */
public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("start");
                boolean flag = true;
                while (flag) {

                }
                System.out.println("end");
            }
        };
        thread1.setName("thread1");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread1.stop();
        System.out.println(thread1.getState());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread1.getState());

        while (true) {
            if (thread1.isInterrupted()) {
                System.out.println("我要退出了");
                break;
            }
        }
    }
}
