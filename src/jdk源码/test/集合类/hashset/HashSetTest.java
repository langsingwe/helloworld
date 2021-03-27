package test.集合类.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className HashSetTest
 * @date 2021.03.23
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(null);
        System.out.println(set);
    }
}
