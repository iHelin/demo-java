package io.github.ihelin.demo.juc;

/**
 * @author iHelin
 * @since 2019/9/5 09:28
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("i am waiting but facing InterruptedException now");
                    }
                }
            }
        });
        thread.start();

        Thread.sleep(500);
        System.out.println(thread.isInterrupted());
        System.out.println(thread.getState());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.getState());
        Thread.sleep(1000);
        System.out.println(thread.getState());
        System.out.println(thread.isInterrupted());
    }
}
