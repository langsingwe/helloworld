package java核心技术卷1. thread.test;

import java.util.concurrent.*;

/**
 * Created by weiliangchun on 2019/11/30
 */
public class Demo4 {
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
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3);
            return 10;
        });
        new Thread(futureTask).start();
        System.out.println(System.currentTimeMillis());
        Integer rs = futureTask.get();
        System.out.println(System.currentTimeMillis() + ":" + rs);
    }
}
