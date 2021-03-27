package test.集合类.linkedlist;

import java.util.LinkedList;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.03.22
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("name");
        list.add("age");
        list.add("kid");
        list.add("father");
        list.remove(1);
        list.add(1, "class");
        list.get(1);
    }
}
