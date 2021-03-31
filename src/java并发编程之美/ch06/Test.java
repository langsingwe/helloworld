package java并发编程之美.ch06;

import java.util.concurrent.locks.LockSupport;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.03.30
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("begin park");

        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();

        System.out.println("end park");
    }
}
