package ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @description
 * @className RuntimeConstantPoolOOM
 * @date 2020-07-29
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        for (; ; ) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
