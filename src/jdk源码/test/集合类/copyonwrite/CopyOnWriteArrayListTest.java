package test.集合类.copyonwrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className CopyOnWriteArrayListTest
 * @date 2021.03.22
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws Exception{
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.remove(0);
        list.add(0, 999);
        list.get(0);

//        final List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                list.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        }).start();

        Thread.sleep(1000);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i+1) + "个元素是：" + list.get(i));
        }

    }
}
