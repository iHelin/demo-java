package me.ianhe.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author iHelin
 * @date 2019-02-28 15:03
 */
public class Test8 {

    private static Integer point = 1000;

    private Test8() {

    }

    static class AddPoint implements Runnable {

        private Lock lock;

        public AddPoint(Lock lock) {
            this.lock = lock;
        }

        void add() {
            lock.lock();
            Test8.point += 1;
            lock.unlock();
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                this.add();
            }
        }
    }

    static class ReducePoint implements Runnable {

        private Lock lock;

        public ReducePoint(Lock lock) {
            this.lock = lock;
        }

        void reduce() {
            lock.lock();
            Test8.point -= 1;
            lock.unlock();
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                this.reduce();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();


        Thread thread1 = new Thread(new AddPoint(lock));
        Thread thread2 = new Thread(new ReducePoint(lock));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(Test8.point);
    }

}




