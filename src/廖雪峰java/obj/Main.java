package com.java.obj;

/**
 * @author weilc
 * @description
 * @className Main
 * @date 2020-06-04
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Student();
        p.run();
    }
}

class Person {
    public void run() {
        System.out.println("Person run");
    }
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student run");
    }
}
