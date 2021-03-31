package java并发编程之美.ch06;

import java.util.concurrent.locks.LockSupport;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test2
 * @date 2021.03.30
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(()->{
            System.out.println("child thread begin park");

            LockSupport.park();

            System.out.println("child thread end park");
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark");

//        LockSupport.unpark(thread);
        thread.interrupt();
    }
}
