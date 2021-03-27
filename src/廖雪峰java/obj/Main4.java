package com.java.obj;

/**
 * @author weilc
 * @description
 * @className Main4
 * @date 2020-06-04
 */
public class Main4 {
    public static void main(String[] args) {
        Adder adder = new Adder();
        adder.add(1).add(2).inc().add(10);
        System.out.println(adder.value());
    }
}

class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }

    public int value() {
        return sum;
    }
}
