package me.ianhe.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock测试
 *
 * @author iHelin
 * @since 2017/11/21 21:56
 */
public class LockTest {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 1; i <= 3; i++) {
            new Thread(ticket, i + "号窗口").start();
        }
    }
}

class Ticket implements Runnable {

    private int ticket = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            while (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + --ticket);
            }
        } finally {
            lock.unlock();
        }
    }
}