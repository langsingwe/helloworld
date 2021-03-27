package java并发编程之美.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className DeadLockTest1
 * @date 2021.03.27
 */
public class DeadLockTest1 {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();
    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
            synchronized (resourceA) {
                System.out.println(Thread.currentThread()+" get resourceA");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                System.out.println(Thread.currentThread()+" waiting get resourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread()+" get resourceB");
                }
            }
        });

        Thread threadB = new Thread(()->{
            synchronized (resourceB) {
                System.out.println(Thread.currentThread()+" get resourceB");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                System.out.println(Thread.currentThread()+" waiting get resourceA");
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread()+" get resourceA");
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
