package java并发编程之美.ch01;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ThreadTest
 * @date 2021.03.26
 */
public class ThreadTest {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallTask());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {

        }
    }
}

class CallTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }
}
