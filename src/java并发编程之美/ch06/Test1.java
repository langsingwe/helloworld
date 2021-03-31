package java并发编程之美.ch06;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test1
 * @date 2021.03.31
 */
public class Test1 {


    static synchronized void method () {
        try {
            System.out.println("method开始");
            Thread.sleep(2000);
            System.out.println("method结束");
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(()->{
            System.out.println("thread1调用method开始");
            method();
            System.out.println("thread1调用method结束");
        });

        Thread thread2 = new Thread(()->{
            System.out.println("thread2调用method开始");
            method();
            System.out.println("thread2调用method结束");
        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
