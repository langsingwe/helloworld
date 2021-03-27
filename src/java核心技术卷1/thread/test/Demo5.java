package thread.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiliangchun on 2019/11/30
 */
public class Demo5 {
    static class Result<T> {
        T result;

        public T getResult() {
            return result;
        }

        public void setResult(T result) {
            this.result = result;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(System.currentTimeMillis());
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 10);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futureTask.run();
        }).start();
        System.out.println(System.currentTimeMillis());
        Integer rs = futureTask.get();
        System.out.println(System.currentTimeMillis() + ":" + rs);
    }
}
