package test.常用类.object;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.03.18
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Object lock = new Object();
        Thread waitThread = new Thread(new WaitThread(lock), "waitThread");
        Thread notifyThread = new Thread(new NotifyThread(lock), "notifyThread");
        waitThread.start();
        Thread.sleep(1000);
        notifyThread.start();
    }
}

class WaitThread implements Runnable {
    Object lock;

    public WaitThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (lock) {
            System.out.println(threadName + "-开始进入同步代码块区域");
            try {
                lock.wait();
            } catch (InterruptedException e) {

            }
            System.out.println(threadName + "-准备离开同步代码块区域");
        }
    }
}

class NotifyThread implements Runnable {
    Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (lock) {
            System.out.println(threadName + "-开始进入同步代码块区域");
            lock.notify();
            try {
                System.out.println(threadName + "-业务处理开始");
                Thread.sleep(2000);
                System.out.println(threadName + "-业务处理结束");
            } catch (InterruptedException e) {

            }
            System.out.println(threadName + "-准备离开同步代码块区域");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        System.out.println(threadName + "-退出代码块后续操作");
    }


}
