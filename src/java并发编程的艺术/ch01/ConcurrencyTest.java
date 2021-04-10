package java并发编程的艺术.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ConcurrencyTest
 * @date 2021.04.09
 */
public class ConcurrencyTest {
    private static final long count = 1000000001;

    private static void concurrency() throws Exception {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(()->{
            int a = 0;
            for (int i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("Concurrency: " + time + " ms , b = " +b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + " ms , b = " + b + ", a=" + a);
    }

    public static void main(String[] args) throws Exception{
        concurrency();
        serial();
    }
}
