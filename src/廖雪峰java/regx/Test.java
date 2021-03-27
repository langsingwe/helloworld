package com.java.regx;

import com.sun.tools.javac.util.List;

/**
 * @author weilc
 * @description
 * @className Test
 * @date 2020-06-25
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String re = "\\d{3,4}-\\d{7,8}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}
