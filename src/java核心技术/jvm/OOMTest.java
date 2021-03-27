package java核心技术.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className OOMTest
 * @date 2021.02.02
 */
public class OOMTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(i);
            i++;
        }
    }
}
