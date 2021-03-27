package test.集合类.treemap;

import java.util.TreeMap;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.03.24
 */
public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(123, "abc");
        map.put(789, "opq");
        map.put(123, "efg");
        map.put(456, "xyz");
        System.out.println(map);
        System.out.println(map.get(123));
    }
}
