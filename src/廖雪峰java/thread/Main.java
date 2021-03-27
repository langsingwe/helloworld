package com.java.thread;

/**
 * @author weilc
 * @description
 * @className Main
 * @date 2020-06-28
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main start....");
        Thread t = new Thread(()->{
            System.out.println("thread run...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread end...");
        });
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end...");
    }
}
