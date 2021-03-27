package com.java.reflect;

import java.lang.reflect.Field;

/**
 * @author weilc
 * @description
 * @className Main2
 * @date 2020-06-05
 */
public class Main2 {
    public static void main(String[] args) throws Exception{
        Person p = new Person("xiao ming");
        System.out.println(p.getName());
        Class clazz = p.getClass();
        Field f = clazz.getDeclaredField("name");
        f.setAccessible(true);
        f.set(p, "xiao hong");
        System.out.println(p.getName());
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}
