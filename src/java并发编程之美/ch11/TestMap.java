package java并发编程之美.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className TestMap
 * @date 2021.04.08
 */
public class TestMap {
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            List<String> list = new ArrayList<>();
            list.add("device1");
            list.add("device2");

            map.put("topic1", list);
            System.out.println(map);
        });
        Thread t2 = new Thread(()->{
            List<String> list = new ArrayList<>();
            list.add("device11");
            list.add("device22");

            map.put("topic1", list);
            System.out.println(map);
        });
        Thread t3 = new Thread(()->{
            List<String> list = new ArrayList<>();
            list.add("device111");
            list.add("device222");

            map.put("topic2", list);
            System.out.println(map);
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
