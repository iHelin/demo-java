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
         * 当前正在执行线程的标记，1代表A，2代表B，3代表C，从A开始
         */
        private int number = 1;

        private Lock lock = new ReentrantLock();
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        private Condition condition3 = lock.newCondition();

        void loopA() {
            lock.lock();
            try {
                if (number != 1) {
                    condition1.await();
                }
                System.out.print(Thread.currentThread().getName());
                //唤醒2
                number = 2;
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void loopB() {
            lock.lock();
            try {
                if (number != 2) {
                    condition2.await();
                }
                System.out.print(Thread.currentThread().getName());
                //唤醒3
                number = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void loopC() {
            lock.lock();
            try {
                if (number != 3) {
                    condition3.await();
                }
                System.out.println(Thread.currentThread().getName());
                //唤醒1
                number = 1;
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        AlternateDemo ad = new AlternateDemo();
        new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                ad.loopA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                ad.loopB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                ad.loopC();
            }
        }, "C").start();
    }
}

