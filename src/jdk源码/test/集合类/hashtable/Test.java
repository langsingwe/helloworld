package test.集合类.hashtable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.03.23
 */
public class Test {
    public static void main(String[] args) throws InterruptedException{
        Hashtable<Integer, Integer> map = new Hashtable<>();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                map.put(i, i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {}
            }
        }).start();

        new Thread(()->{
            for (int i = 10; i < 20; i++) {
                map.put(i, i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {}
            }
        }).start();

        Thread.sleep(1000);
        System.out.println(map);
    }
}
