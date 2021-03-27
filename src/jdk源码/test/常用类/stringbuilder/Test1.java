package test.常用类.stringbuilder;

import java.util.Arrays;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test1
 * @date 2021.03.18
 */
public class Test1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        System.out.println(sb);

        byte[] src = {1, 2, 3, 4, 5};
        byte[] dest = new byte[5];
        System.arraycopy(src, 1, dest, 1, 4);
        System.out.println(Arrays.toString(dest));
    }
}
