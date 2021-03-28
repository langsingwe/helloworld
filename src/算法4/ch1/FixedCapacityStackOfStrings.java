package ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName FixedCapacityStackOfStrings
 * created by weilc on 2019/12/18 9:58
 */
public class FixedCapacityStackOfStrings<T> {
    private T[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = (T[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        a[N++] = item;
    }

    public T pop() {
        return a[N--];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack");
    }
}
