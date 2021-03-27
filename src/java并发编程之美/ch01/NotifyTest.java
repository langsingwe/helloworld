package java并发编程之美.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className NotifyTest
 * @date 2021.03.26
 */
public class NotifyTest {
    private static volatile Object resource = new Object();
    public static void main(String[] args) throws Exception{
        Thread threadA = new Thread(()->{
            synchronized (resource) {
                System.out.println("threadA get resource lock");
                try {
                    System.out.println("threadA begin wait");
                    resource.wait();
                    System.out.println("threadA end wait");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(()->{
            synchronized (resource) {
                System.out.println("threadB get resource lock");
                try {
                    System.out.println("threadB begin wait");
                    resource.wait();
                    System.out.println("threadB end wait");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Thread threadC = new Thread(()->{
            synchronized (resource) {
                System.out.println("threadC get resource lock");
                try {
                    System.out.println("threadC begin notify");
                    resource.notifyAll();
                    System.out.println("threadC end notify");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("over");
    }
}
