package io.github.ihelin.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author iHelin
 * @since 2018/10/2 10:04
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(producer, "生产者 1").start();
        new Thread(consumer, "消费者 2").start();
        new Thread(producer, "生产者 3").start();
        new Thread(consumer, "消费者 4").start();

    }

    //店员
    private static class Clerk {

        private int product = 0;
        private final int threshold = 10;

        /**
         * 进货/上架
         */
        synchronized void get() {
            while (product >= threshold) {
                System.out.println("货架已满！");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "上架了一件商品，剩余: " + ++product);
            this.notifyAll();
        }

        /**
         * 卖货
         */
        synchronized void sale() {
            // 为了避免虚假唤醒，应该总是使用在循环中。
            while (product <= 0) {
                System.out.println("货架缺货！");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "购买了一件商品，剩余: " + --product);
            this.notifyAll();
        }
    }

    // 生产者
    static class Producer implements Runnable {
        private final Clerk clerk;

        Producer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.get();
            }
        }
    }

    // 消费者
    static class Consumer implements Runnable {
        private final Clerk clerk;

        Consumer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.sale();
            }
        }
    }
}
