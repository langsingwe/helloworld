package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by weiliangchun on 2019/11/27
 */
public class AtomicTest3 {
    //账户原始余额
    static int accountMoney = 19;
    //用于对账户余额做原子操作
    static AtomicReference<Integer> money = new AtomicReference<>(accountMoney);

    /**
     * 模拟2个线程同时更新后台数据库，为用户充值
     */
    static void recharge() {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    Integer m = money.get();
                    if (m == accountMoney) {
                        if (money.compareAndSet(m, m + 20)) {
                            System.out.println("当前余额:" + m + "，小于20，充值20元成功！");
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 模拟用户消费
     *
     * @throws InterruptedException
     */
    static void consume() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Integer m = money.get();
            if (m > 20) {
                if (money.compareAndSet(m, m - 20)) {
                    System.out.println("当前余额：" + m + ",大于20.成功消费20元，余额：" + money.get() + "元");
                }
            }
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        recharge();
        consume();
    }
}
