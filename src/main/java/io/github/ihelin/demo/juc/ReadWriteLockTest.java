package io.github.ihelin.demo.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1. ReadWriteLock : 读写锁
 * 写写/读写 需要“互斥”
 * 读读 不需要互斥
 *
 * @author iHelin
 * @since 2017/11/23 14:07
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(() -> rw.set((int) (Math.random() * 101)), "Write:").start();

        for (int i = 0; i < 100; i++) {
            new Thread(rw::read, "Read:").start();
        }
    }

    static class ReadWriteLockDemo {

        private int number = 0;

        private final ReadWriteLock lock = new ReentrantReadWriteLock();

        /**
         * 读
         */
        void read() {
            lock.readLock().lock(); //上锁

            try {
                System.out.println(Thread.currentThread().getName() + " : " + number);
            } finally {
                lock.readLock().unlock(); //释放锁
            }
        }

        /**
         * 写
         *
         * @param number 待写入的值
         */
        void set(int number) {
            lock.writeLock().lock();

            try {
                System.out.println(Thread.currentThread().getName() + number);
                this.number = number;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

}