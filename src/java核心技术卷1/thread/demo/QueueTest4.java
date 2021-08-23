package java核心技术卷1. thread.demo;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by weiliangchun on 2019/11/28
 */
public class QueueTest4 {
    static class Msg implements Delayed {
        private int priority;
        private String msg;
        private long sendTimeMs;

        public Msg(int priority, String msg, long sendTimeMs) {
            this.priority = priority;
            this.msg = msg;
            this.sendTimeMs = sendTimeMs;
        }

        @Override
        public int compareTo(Delayed o) {
            if (o instanceof Msg) {
                Msg c2 = (Msg) o;
                return Integer.compare(this.priority, c2.priority);
            }
            return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.sendTimeMs - Calendar.getInstance().getTimeInMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "priority=" + priority +
                    ", msg='" + msg + '\'' +
                    ", sendTimeMs=" + sendTimeMs +
                    '}';
        }
    }

    static DelayQueue<Msg> pushQueue = new DelayQueue<>();

    static {
        new Thread(() -> {
            while (true) {
                Msg msg;
                try {
                    msg = pushQueue.take();
                    long endTime = System.currentTimeMillis();
                    System.out.println("定时发送时间:" + msg.sendTimeMs + "，实际发送时间:" + endTime + ",发送消息：" + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void pushMsg(int priority, String msg, long sendTimeMs) {
        pushQueue.put(new Msg(priority, msg, sendTimeMs));
    }

    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            String msg = "一起来学java高并发，第" + i + "天";
            QueueTest4.pushMsg(i, msg, Calendar.getInstance().getTimeInMillis() + i * 2000);
        }
    }
}
