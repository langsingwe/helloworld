package com.java.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author weilc
 * @description https://how2j.cn/k/exception/exception-trycatch/336.html#nowhere
 * @className TestException
 * @date 2020-05-28
 */
public class TestException {

    public static void main(String[] args) {
        File file = new File("~/LOL.exe");
        try {
            System.out.println("试图打开 ~/LOL.exe");
            new FileInputStream(file);
            System.out.println("成功打开");
        } catch (FileNotFoundException e) {
            System.out.println("LOL.exe不存在");
            e.printStackTrace();
        } finally {
            System.out.println("无论文件是否存在，都会执行的代码");
        }
//        System.out.println(method());
    }

    public static int method() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
