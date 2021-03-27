package com.java.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weilc
 * @description
 * @className WaitTest
 * @date 2020-07-01
 */
public class WaitTest {
    public static void main(String[] args) throws InterruptedException{
        TaskQueue queue = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(()->{
                while (true) {
                    try {
                        String s = queue.getTask();
                        System.out.println("execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                queue.addTask(s);
                try  {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }
    }
}
class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}