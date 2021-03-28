package ch02;

/**
 * @author weilc
 * @description
 * @className JavaVMStackOOM
 * @date 2020-07-29
 */
public class JavaVMStackOOM {
    private void dontStop() {
        for (; ; ) {

        }
    }

    public void stackLeakByThread() {
        for (; ; ) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
