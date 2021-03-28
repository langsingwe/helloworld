package java并发编程之美.ch04;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className AtomicTest
 * @date 2021.03.27
 */
public class AtomicTest {
    private static AtomicLong atomicLong = new AtomicLong();
//    private static long atomicLong;

    private static Integer[] arr1 = new Integer[]{0,1,2,3,0,5,6,0,67,0};
    private static Integer[] arr2 = new Integer[]{10,11,21,3,0,5,6,0,67,0};

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()-> {
            int size = arr1.length;
            for (int i = 0; i < size; ++i) {
                if (arr1[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
//                    atomicLong++;
                }
            }
        });
        Thread t2 = new Thread(()->{
            int size = arr2.length;
            for (int i = 0; i < size; ++i) {
                if (arr2[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
//                    atomicLong++;
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count 0:" + atomicLong.get());
//        System.out.println("count 0:" + atomicLong);
    }

}
