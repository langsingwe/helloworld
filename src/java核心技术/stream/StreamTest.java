package java核心技术.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName StreamTest
 * @Author weilc
 * @Date 2020-11-12
 * @Version 1.0
 */
public class StreamTest {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList(new String[]{"Q", "C", "D"});
//        Optional<String> q = strings.java核心技术.stream().filter(w -> w.startsWith("Q")).findFirst();
//        if (q.isPresent()) {
//            System.out.println(q.get());
//        }
//
//        String[] strings1 = {"z", "x", "c", "v"};
//        Stream<String> java核心技术.stream = Arrays.java核心技术.stream(strings1);
//        HashSet<String> map1 = java核心技术.stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
//        System.out.println(map1);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long s1 = System.currentTimeMillis();
        list.forEach(m->{
            m++;
        });
        System.out.println("第1次时间: " + (System.currentTimeMillis() - s1));

        long s2 = System.currentTimeMillis();
        list.stream().forEach(m->m++);
        System.out.println("第2次时间: " + (System.currentTimeMillis() - s2));
    }

}
