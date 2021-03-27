package com.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author weilc
 * @description
 * @className Test
 * @date 2020-06-22
 */
public class Test {
    public static void main(String[] args) throws IOException{
        String s;
        try (InputStream input = new FileInputStream("/Users/weiliangchun/Downloads/test.txt")) {
            s = readAsString(input);
        }
        System.out.println(s);
    }

    public static String readAsString(InputStream in) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = in.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }
}
