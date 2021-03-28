package ch1;

/**
 * @ClassName Accumulator
 * created by weilc on 2019/12/17 14:44
 */
public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Meas(" + N + " values):" + String.format("%7.5f", mean());
    }
}
