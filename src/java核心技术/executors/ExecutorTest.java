package java核心技术.executors;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Description
 * @ClassName ExecutorTest
 * @Author weilc
 * @Date 2020-11-24
 * @Version 1.0
 */
public class ExecutorTest {
    public static void main(String[] args) {
        try {
            long total = 0;
            long start = System.currentTimeMillis();
            ExecutorService executor = Executors.newFixedThreadPool(8);
            List<Future<Long>> futures = new CopyOnWriteArrayList<>();
            CountDownLatch latch = new CountDownLatch(20);
            for (int i = 0; i < 20; i++) {
                Task task = new Task(100000, "任务-" + i);
                futures.add(executor.submit(task));
                latch.countDown();
                System.out.println("next task...");
            }
            executor.shutdown();
            latch.await();
            for (Future<Long> future : futures) {
                total += future.get();
            }
            System.out.println("总耗时：" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Task implements Callable<Long> {
    private long times;
    private String name;
    public Task(long times, String name) {
        this.name = name;
        this.times = times;
    }
    @Override
    public Long call() {
        System.out.println(name + "-->执行开始.");
        long before = System.currentTimeMillis();
        for (int i = 0; i < times; i++){}
        long after = System.currentTimeMillis();
        System.out.println(name + "-->执行结束.");
        long cost = after - before;
        return cost;
    }
}