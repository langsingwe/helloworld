package ch1;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName Interval2dTest
 * created by weilc on 2019/12/17 10:41
 */
public class Interval2dTest {
    public static void main(String[] args) {
        double xlo = .2;
        double xhi = .5;
        double ylo = .5;
        double yhi = .6;
        int T = 10000;

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Counter c = new Counter("hits");
        for (int i = 0; i < T; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) {
                c.increment();
            } else {
                p.draw();
            }
        }
        StdOut.println(c);
        StdOut.println(box.area());
    }
}
