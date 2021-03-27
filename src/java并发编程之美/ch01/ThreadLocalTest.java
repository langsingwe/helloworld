package java并发编程之美.ch01;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ThreadLocalTest
 * @date 2021.03.27
 */
public class ThreadLocalTest {

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String string) {
        System.out.println(string + ":" + localVariable.get());

//        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
            localVariable.set("threadA local variable");

            print("threadA");

            System.out.println("threadA remove after" + ":"  + localVariable.get());
        });

        Thread threadB = new Thread(()->{
            localVariable.set("threadB local variable");

            print("threadB");

            System.out.println("threadB remove after" + ":"  + localVariable.get());
        });

        threadA.start();
        threadB.start();
    }
}
