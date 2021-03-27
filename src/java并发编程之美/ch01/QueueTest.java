package java并发编程之美.ch01;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className QueueTest
 * @date 2021.03.26
 */
public class QueueTest {

    private static final int MAX_SIZE = 1;
    private static volatile LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws Exception{
        Thread product = new Thread(()->{
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    try {
                        System.out.println("生产者线程阻塞");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产者添加元素");
                queue.add(1);
                queue.notifyAll();
            }
        });

        Thread consumer = new Thread(()->{
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        System.out.println("消费者线程阻塞");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    queue.take();
                    System.out.println("消费者线程消费");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        });

        consumer.start();
        Thread.sleep(1000);
        product.start();
    }
}
