package ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * @ClassName Cat
 * created by weilc on 2019/12/17 14:06
 */
public class Cat {
    public static void main(String[] args) {
        Out out = new Out("c:/out.txt");

        for (int i = 1; i < 3; i++) {
            In in = new In("c:/in" + i + ".txt");
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }
}
