package com.java.io;

import java.io.File;

/**
 * @author weilc
 * @description
 * @className IOTest
 * @date 2020-06-22
 */
public class IOTest {
    public static void main(String[] args) {
        File f1 = new File("/Users/weiliangchun/Downloads/opendb.sql");
        File f2 = new File("/Users/weiliangchun/Downloads");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
    }
}
