package java并发编程之美.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className WaitTest
 * @date 2021.03.26
 */
public class WaitTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();
    public static void main(String[] args) throws Exception{
        Thread threadA = new Thread(()->{
            try {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    synchronized (resourceB) {
                        System.out.println("threadA get resourceB lock");
                        System.out.println("threadA release resourceA lock");
                        resourceA.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(()-> {
            try {
                Thread.sleep(1000);
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    System.out.println("threadB try get resourceB lock");
                    synchronized (resourceB) {
                        System.out.println("threadB get resourceB lock");
                        System.out.println("threadB release resourceA lock");
                        resourceA.wait();
                    }
                }
            } catch (Exception e) {

            }
        });
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("over");
    }
}
