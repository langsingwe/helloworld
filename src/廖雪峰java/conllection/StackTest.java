package com.java.conllection;

import java.util.Stack;

/**
 * @author weilc
 * @description
 * @className StackTest
 * @date 2020-06-22
 */
public class StackTest {
    static Stack stack = new Stack();

    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Stack stack = getStack(n);
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(stack.pop());
            if (stack.size() == 0) {
                break;
            }
        }
        return sb.toString();
    }

    static Stack getStack(int n) {
        int x = n % 16;
        n = n / 16;
        String s = "";
        switch (x) {
            case 10:
                s = "A";
                break;
            case 11:
                s = "B";
                break;
            case 12:
                s = "C";
                break;
            case 13:
                s = "D";
                break;
            case 14:
                s = "E";
                break;
            case 15:
                s = "F";
                break;
            default:
                s = String.valueOf(x);
                break;

        }
        stack.push(s);
        if (n == 0) {
            return stack;
        }
        return getStack(n);
    }
}
