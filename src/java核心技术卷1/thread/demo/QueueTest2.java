package java核心技术卷1. thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiliangchun on 2019/11/28
 */
public class QueueTest2 {
    static class Msg implements Comparable<Msg> {
        private int priority;
        private String msg;

        public Msg(int priority, String msg) {
            this.priority = priority;
            this.msg = msg;
        }

        @Override
        public int compareTo(Msg o) {
            return Integer.compare(this.priority, o.priority);
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "priority=" + priority +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

    static PriorityBlockingQueue<Msg> pushQueue = new PriorityBlockingQueue<>();

    static {
        new Thread(() -> {
            while (true) {
                Msg msg;
                try {
                    long startTime = System.currentTimeMillis();
                    msg = pushQueue.take();
                    TimeUnit.MILLISECONDS.sleep(100);
                    long endTime = System.currentTimeMillis();
                    System.out.println("开始时间：" + startTime + ",结束时间：" + endTime + ",耗时：" + (endTime - startTime) + "," + Thread.currentThread().getName() + "发送消息：" + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void pushMsg(int priority, String msg) {
        pushQueue.put(new Msg(priority, msg));
    }

    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            String msg = "一起来学java高并发，第" + i + "天";
            QueueTest2.pushMsg(i, msg);
        }
    }
}
