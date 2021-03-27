package com.java.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author weilc
 * @description
 * @className Test
 * @date 2020-07-04
 */
public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Alice", "Tim");
        List<Person> personList = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(personList);
    }
}
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}