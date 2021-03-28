package java并发编程之美.ch02;

import sun.misc.Unsafe;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className UnsafeTest
 * @date 2021.03.27
 */
public class UnsafeTest {
    static final Unsafe unsafe = Unsafe.getUnsafe();

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }


    public static void main(String[] args) {
        UnsafeTest test = new UnsafeTest();
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
