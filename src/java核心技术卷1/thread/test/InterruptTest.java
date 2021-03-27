package thread.test;

/**
 * @author weilc
 * @description
 * @className InterruptTest
 * @date 2020-05-16
 */
public class InterruptTest implements Runnable {
    @Override
    public void run() {
        System.out.println("线程启动");
        try {
            System.out.println(Thread.currentThread().isInterrupted());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束");
    }

    public static void main(String[] args) {
        InterruptTest r = new InterruptTest();
        Thread t = new Thread(r);
        t.start();
        t.interrupt();
    }
}
