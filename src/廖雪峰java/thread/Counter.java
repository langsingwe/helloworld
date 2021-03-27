package com.java.thread;

/**
 * @author weilc
 * @description
 * @className Counter
 * @date 2020-06-30
 */
public class Counter {

    private int count = 0;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}
