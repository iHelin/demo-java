package io.github.ihelin.demo.juc;

public class Thread8MonitorTest {

    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();
        new Thread(() -> Number.getOne()).start();

        new Thread(() -> {
//                number.getTwo();
            Number.getTwo();
        }).start();

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                number.getThree();
            }
        }).start();*/
    }

    static class Number {
        static synchronized void getOne() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
        }

        static synchronized void getTwo() {
            System.out.println("two");
        }

//    public void getThree() {
//        System.out.println("three");
//    }
    }

}