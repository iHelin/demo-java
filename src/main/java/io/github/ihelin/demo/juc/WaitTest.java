package io.github.ihelin.demo.juc;

/**
 * @author iHelin
 * @date 2019-02-22 17:28
 */
public class WaitTest {


    /**
     * 创建个共享对象做监视器用
     */
    private static final Object OBJECT = new Object();

    /**
     * 大木盘子，一盘最多可盛10份饺子，厨师做满10份，服务员就可以端出去了。
     */
    private static Integer platter = 0;

    /**
     * 卖出的饺子总量，卖够100份就打烊收工
     */
    private static Integer count = 0;

    /**
     * 厨师
     */
    static class Cook implements Runnable {

        @Override
        public void run() {
            while (count < 100) {
                synchronized (OBJECT) {
                    while (platter < 10) {
                        try {
                            platter++;
                            System.out.println(Thread.currentThread().getName() + "：完成" + platter + "份饺子");
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count += 10;
                    System.out.println(Thread.currentThread().getName() + "：一共完成" + count + "份饺子");

                    System.out.println(Thread.currentThread().getName() + "：饺子好啦，厨师休息会儿");
                    //通知服务员饺子好了，可以端走了
                    OBJECT.notify();
                }
                try {
                    //线程睡一会，帮助服务员线程抢到对象锁
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "：打烊收工，回家");
        }
    }

    /**
     * 服务员
     */
    static class Waiter implements Runnable {

        @Override
        public void run() {
            while (count < 100) {
                synchronized (OBJECT) {
                    //厨师做够10份了，就可以端出去了
                    while (platter < 10) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "：饺子还没好，等待厨师通知...");
                            OBJECT.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //饺子端给客人了，盘子清空
                    platter -= 10;
                    System.out.println(Thread.currentThread().getName() + "：把饺子端给客人了");
                }
            }
            System.out.println(Thread.currentThread().getName() + "：打烊收工，回家");
        }
    }

    public static void main(String[] args) {
        Thread cookThread = new Thread(new Cook(), "厨师");
        Thread waiterThread = new Thread(new Waiter(), "服务员");
        cookThread.start();
        waiterThread.start();
    }
}
