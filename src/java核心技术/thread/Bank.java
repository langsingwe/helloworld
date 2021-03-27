package java核心技术.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Bank
 * @date 2021.03.14
 */
public class Bank {

    private final double[] accounts;
    private Lock lock;
    private Condition condition;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException{
        lock.lock();
        try {
            while (accounts[from] < amount) {
                condition.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

    public static void main(String[] args) {
        int NACCOUNTS = 100;
        double INITIAL_BALANCE = 1000;
        double MAX_AMOUNT = 1000;
        int DELAY = 10;
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    int toAccount = (int) (bank.size() * Math.random());
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(fromAccount, toAccount, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                } catch (InterruptedException e) {

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
