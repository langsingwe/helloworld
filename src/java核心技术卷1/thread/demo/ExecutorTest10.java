package thread.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * Created by weiliangchun on 2019/11/25
 */
public class ExecutorTest10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ArrayList<Callable<Integer>> list = new ArrayList<>();
        int taskCount = 5;
        for (int i = taskCount; i > 0; i--) {
            int j = i * 2;
            list.add(() -> {
                TimeUnit.SECONDS.sleep(j);
                return j;
            });
        }
        solve(executorService, list, a -> {
            System.out.println(System.currentTimeMillis() + ":" + a);
        });
        executorService.shutdown();
    }

    public static <T> void solve(Executor e, Collection<Callable<T>> solvers, Consumer<T> use) throws InterruptedException, ExecutionException {
        ExecutorCompletionService<T> executorCompletionService = new ExecutorCompletionService<>(e);
        for (Callable<T> solver : solvers) {
            executorCompletionService.submit(solver);
        }
        int n = solvers.size();
        for (int i = 0; i < n; i++) {
            T r = executorCompletionService.take().get();
            if (r != null) {
                use.accept(r);
            }
        }
    }
}
