package com.study.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock banKLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        banKLock = new ReentrantLock();
        sufficientFunds = banKLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        banKLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance :%10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            banKLock.unlock();
        }

    }

    private double getTotalBalance() {
        banKLock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            banKLock.unlock();
        }

    }

    public int size() {
        return this.accounts.length;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accounts=" + Arrays.toString(accounts) +
                ", banKLock=" + banKLock +
                ", sufficientFunds=" + sufficientFunds +
                '}';
    }
}
