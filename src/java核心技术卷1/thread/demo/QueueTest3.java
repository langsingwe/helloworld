package java核心技术卷1. thread.demo;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiliangchun on 2019/11/28
 */
public class QueueTest3 {
    static SynchronousQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                long startTime = System.currentTimeMillis();
                queue.put("java哈哈");
                long endTime = System.currentTimeMillis();
                System.out.println("开始时间：" + startTime + ",结束时间：" + endTime + ",耗时：" + (endTime - startTime) + "," + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis() + "调用take获取并移除元素," + queue.take());
    }
}
