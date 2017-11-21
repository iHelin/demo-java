package me.ianhe.thread;

/**
 * 线程测试
 *
 * @author iHelin
 * @since 2017/11/21 12:00
 */
public class Actor extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + "是一个好演员！");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "登台演出:" + (++count) + "次");
            if (count == 50) {
                keepRunning = false;
            }
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + "的演出结束了！");

    }

    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actress = new Thread(new Actress());
        actress.setName("Ms.Runnable");
        actress.start();
    }

}

class Actress implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "是一个好演员！");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "登台演出:" + (++count) + "次");
            if (count == 50) {
                keepRunning = false;
            }
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "的演出结束了！");

    }

}
