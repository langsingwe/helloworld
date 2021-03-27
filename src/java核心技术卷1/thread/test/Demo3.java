package thread.test;

import java.util.concurrent.*;

/**
 * Created by weiliangchun on 2019/11/30
 */
public class Demo3 {
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
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(System.currentTimeMillis());
        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        executorService.shutdown();
        System.out.println(System.currentTimeMillis());
        Integer rs = future.get();
        System.out.println(System.currentTimeMillis() + ":" + rs);
    }
}
