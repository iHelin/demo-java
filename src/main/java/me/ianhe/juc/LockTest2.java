package me.ianhe.juc;

/**
 * @author iHelin
 * @date 2019-02-22 17:28
 */
public class LockTest2 {

    public static void main(String[] args) {
        demo3();
    }

    private static void demo3() {
        Object lock = new Object();
        Thread A = new Thread(() -> {
            System.out.println("INFO: A is waiting for the lock");
            synchronized (lock) {
                System.out.println("INFO: A got the lock");
                System.out.println("A 1");
                try {
                    System.out.println("INFO: A is ready to enter the wait state, giving up control of the lock");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("INFO: B wakes up A, and A regains the lock");
                System.out.println("A 2");
                System.out.println("A 3");
            }
        });
        Thread B = new Thread(() -> {
            System.out.println("INFO: B is waiting for the lock");
            synchronized (lock) {
                System.out.println("INFO: B got the lock");
                System.out.println("B 1");
                System.out.println("B 2");
                System.out.println("B 3");
                System.out.println("INFO: B ends printing, and calling the notify method");
                lock.notify();
            }
        });
        A.start();
        B.start();
    }
}
