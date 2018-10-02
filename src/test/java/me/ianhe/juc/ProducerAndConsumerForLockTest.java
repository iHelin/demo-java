package me.ianhe.juc;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者案例
 *
 * @author iHelin
 * @since 2017/11/23 14:07
 */
public class ProducerAndConsumerForLockTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer, "生产者 A").start();
        new Thread(consumer, "消费者 B").start();
        new Thread(producer, "生产者 C").start();
        new Thread(consumer, "消费者 D").start();
    }

    private static class Clerk {
        private int product = 0;
        private int threshold = 5;
        private ReentrantLock reentrantLock = new ReentrantLock();
        private Condition condition = reentrantLock.newCondition();

        /**
         * 进货/上架
         */
        public void get() {
            reentrantLock.lock();
            try {
                // 为了避免虚假唤醒，应该总是使用在循环中。
                while (product >= threshold) {
                    System.out.println("货架已满！");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "上架了一件商品，剩余: " + ++product);
                condition.signalAll();
            } finally {
                reentrantLock.unlock();
            }
        }

        /**
         * 卖货
         */
        public void sale() {
            reentrantLock.lock();
            try {
                while (product <= 0) {
                    System.out.println("货架缺货！");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "购买了一件商品，剩余: " + --product);
                condition.signalAll();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    // 生产者
    static class Producer implements Runnable {
        private Clerk clerk;

        Producer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.get();
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 消费者
    static class Consumer implements Runnable {
        private Clerk clerk;

        Consumer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.sale();
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}