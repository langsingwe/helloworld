package ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName TestVisualAccumulator
 * created by weilc on 2019/12/17 14:51
 */
public class TestVisualAccumulator {
    public static void main(String[] args) {
        int T = 2000;
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
