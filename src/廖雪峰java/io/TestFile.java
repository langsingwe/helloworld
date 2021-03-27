package com.java.io;

import java.io.File;

/**
 * @author weilc
 * @description
 * @className TestFile
 * @date 2020-05-28
 */
public class TestFile {
    public static void main(String[] args) {
        File f1 = new File("/LOLFolder");
        System.out.println("f1 绝对路径：" + f1.getAbsolutePath());
        File f2 = new File("LOL.exe");
        System.out.println("f2 绝对路径：" + f2.getAbsolutePath());

        File f3 = new File(f1, "LOL.exe");
        System.out.println("f3 绝对路径：" + f3.getAbsolutePath());
    }
}
