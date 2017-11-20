package me.ianhe.test;

public class ThreadTest {

    public static void main(String args[]) {
        /**
         * 创建sub线程
         */
        SubThread subThread = new SubThread();
        Thread t = new Thread(subThread, "Sub Thread");
        t.start();
        System.out.println("Main thread start");
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }

}

class SubThread implements Runnable {
    /**
     * sub线程入口
     */
    @Override
    public void run() {
        System.out.println("Sub thread start");
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Sub Thread: " + i);
                // 暂停线程
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Sub interrupted.");
        }
        System.out.println("Exiting sub thread.");
    }
}
