package me.ianhe.juc;

import java.util.concurrent.TimeUnit;

/**
 * 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 相较于 synchronized 是一种较为轻量级的同步策略。
 * <p>
 * 注意：
 * 1. volatile 不具备"互斥性"
 * 2. volatile 不能保证变量的"原子性"
 *
 * @author iHelin
 * @since 2017/11/23 14:10
 */
public class VolatileTest {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while (true) {
            if (td.isFlag()) {
                System.out.println("------------------");
                break;
            }
        }
    }

    static class ThreadDemo implements Runnable {

        /**
         * 两个线程共享的变量
         * volatile：子线程修改为true，主线程可见
         */
        private volatile boolean flag = false;

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setFlag(true);
            System.out.println("set flag=" + isFlag());
        }

        boolean isFlag() {
            return flag;
        }

        void setFlag(boolean flag) {
            this.flag = flag;
        }

    }


}
