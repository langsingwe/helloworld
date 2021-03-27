package com.java.obj;

/**
 * @author weilc
 * @description
 * @className Main3
 * @date 2020-06-04
 */
public class Main3 {
    public static void main(String[] args) {
        Person2 ming = new Person2("Xiao Ming", 12);
        Person2 hong = new Person2("Xiao Hong", 15);
        Person2.number = 88;
        System.out.println(Person2.number);
        Person2.number = 99;
        System.out.println(Person2.number);
    }
}

class Person2 {
    public String name;
    public int age;
    public static int number;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
