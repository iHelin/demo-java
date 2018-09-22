package me.ianhe.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的名称分别为 A、B、C，每个线程将自己的ID在屏幕上打印10遍，
 * 要求输出的结果必须按顺序显示。
 * 如：ABCABCABC…… 依次递归
 *
 * @author iHelin
 * @since 2017/11/22 09:48
 */
public class ABCAlternateTest {

    static class AlternateDemo {

        /**
         * 当前正在执行线程的标记，从A开始
         */
        private char currentTag = 'A';

        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();

        void loopA() {
            lock.lock();
            try {
                if (currentTag != 'A') {
                    conditionA.await();
                }
                System.out.print(Thread.currentThread().getName());
                //唤醒B
                currentTag = 'B';
                conditionB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void loopB() {
            lock.lock();
            try {
                if (currentTag != 'B') {
                    conditionB.await();
                }
                System.out.print(Thread.currentThread().getName());
                //唤醒C
                currentTag = 'C';
                conditionC.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void loopC() {
            lock.lock();
            try {
                if (currentTag != 'C') {
                    conditionC.await();
                }
                System.out.print(Thread.currentThread().getName());
                //唤醒A
                currentTag = 'A';
                conditionA.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        int loopCount = 10;
        AlternateDemo ad = new AlternateDemo();
        new Thread(() -> {
            for (int i = 1; i <= loopCount; i++) {
                ad.loopA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= loopCount; i++) {
                ad.loopB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= loopCount; i++) {
                ad.loopC();
            }
        }, "C").start();
    }
}

