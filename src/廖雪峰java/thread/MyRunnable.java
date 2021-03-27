package com.java.thread;

import java.util.Date;

/**
 * @author weilc
 * @description
 * @className MyRunnable
 * @date 2020-07-27
 */
public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()  + " Start. Time = " + new Date());
        commandProcess();
        System.out.println(Thread.currentThread().getName()  + " End. Time = " + new Date());
    }

    private void commandProcess() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
