package java核心技术.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @ClassName LambdaTest
 * @Author weilc
 * @Date 2020-11-10
 * @Version 1.0
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] strings = {"aa", "aaa", "a", "aaaa"};
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        Arrays.sort(strings, comparator);

    }
}
