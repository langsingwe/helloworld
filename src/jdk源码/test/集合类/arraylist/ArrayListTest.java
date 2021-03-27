package test.集合类.arraylist;

import java.util.ArrayList;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ArrayListTest
 * @date 2021.03.19
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(18);
        System.out.println(list.size());
        list.add(0);
        list.remove(0);
        list.add(0,1);
        list.get(0);
    }
}
