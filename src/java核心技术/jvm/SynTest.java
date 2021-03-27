package java核心技术.jvm;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className SynTest
 * @date 2021.02.01
 */
public class SynTest {
    public synchronized void test1() {
        System.out.println("do test1");
    }

    public void test2() {
        synchronized (this) {
            System.out.println("do test2");
        }
    }
}
