package test.集合类.hashmap;

import java.util.HashMap;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.03.22
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 15; i++) {
            map.put("name" + i, "zhangsan" + i);
        }
        System.out.println(map);
        String name1 = map.get("name1");
        System.out.println(name1);
        map.remove("name1");
    }
}
