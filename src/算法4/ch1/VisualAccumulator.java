package ch1;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @ClassName VisualAccumulator
 * created by weilc on 2019/12/17 14:47
 */
public class VisualAccumulator {
    private double total;
    private int N;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, total / N);
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Meas(" + N + " values):" + String.format("%7.5f", mean());
    }
}
