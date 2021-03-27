package 算法.线程;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className PrintABCUseWait
 * @date 2021.02.01
 */
public class PrintABCUseWait {
    private int times;
    private int state;
    private static final Object lock = new Object();

    public PrintABCUseWait(int times) {
        this.times = times;
    }

    void print(String str, int targetState) {
        for (int i = 0; i < times; i++) {
            synchronized (lock) {
                while (state % 3 != targetState) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.println(str);
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUseWait demo = new PrintABCUseWait(3);
        new Thread(()-> {
            demo.print("A", 0);
        }).start();
        new Thread(()-> {
            demo.print("B", 1);
        }).start();
        new Thread(()-> {
            demo.print("C", 2);
        }).start();
    }
}
