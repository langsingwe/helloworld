package thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiliangchun on 2019/11/28
 */
public class QueueTest1 {
    //推送队列
    static ArrayBlockingQueue<String> pushQueue = new ArrayBlockingQueue<>(10000);

    static {
        //启动一个线程做真实推送
        new Thread(() -> {
            while (true) {
                String msg;
                try {
                    long startTime = System.currentTimeMillis();
                    msg = pushQueue.take();
                    long endTime = System.currentTimeMillis();
                    //模拟推送耗时
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("开始时间：" + startTime + ",结束时间：" + endTime + ",耗时：" + (endTime - startTime) + "," + Thread.currentThread().getName() + "发送消息：" + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //推送消息，需要发送推送小弟的调用该方法，会将推送信息先加入推送队列
    public static void pushMsg(String msg) throws InterruptedException {
        pushQueue.put(msg);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            String msg = "一起来学java高并发，第" + i + "天";
            TimeUnit.SECONDS.sleep(i);
            QueueTest1.pushMsg(msg);
        }
    }
}
