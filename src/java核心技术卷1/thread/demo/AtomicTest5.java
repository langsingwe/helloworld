package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by weiliangchun on 2019/11/27
 */
public class AtomicTest5 {
    static AtomicTest5 test5 = new AtomicTest5();
    //isInit用来标注是否被初始化过
    volatile Boolean isInit = false;
    AtomicReferenceFieldUpdater<AtomicTest5, Boolean> updater = AtomicReferenceFieldUpdater.newUpdater(AtomicTest5.class, Boolean.class, "isInit");

    public void init() throws InterruptedException {
        if (updater.compareAndSet(test5, false, true)) {
            System.out.println(System.currentTimeMillis() + "，" + Thread.currentThread().getName() + "，开始初始化!");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(System.currentTimeMillis() + "，" + Thread.currentThread().getName() + "，初始化完毕！");
        } else {
            System.out.println(System.currentTimeMillis() + "，" + Thread.currentThread().getName() + "，有其他线程已经执行了初始化");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    test5.init();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
