package io.github.ihelin.demo.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 协作之Semaphore
 *
 * @author iHelin
 * @since 2017/12/20 11:10
 */
public class SemaphoreTest {
    static class Parking {

        /**
         * 信号量
         */
        private final Semaphore semaphore;

        Parking(int count) {
            semaphore = new Semaphore(count);
        }

        public void park() {
            try {
                //获取信号量
                semaphore.acquire();
                int time = new Random().nextInt(10);
                System.out.println(Thread.currentThread().getName() + "进入停车场，停车" + time + "秒...");
                TimeUnit.SECONDS.sleep(time);
                System.out.println(Thread.currentThread().getName() + "开出停车场...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }


    static class Car extends Thread {
        Parking parking;

        Car(Parking parking) {
            this.parking = parking;
        }

        @Override
        public void run() {
            parking.park();     //进入停车场
        }
    }

    public static void main(String[] args) {
        int count = 3;
        //假设停车场有[count]个停车位
        Parking parking = new Parking(count);
        for (int i = 0; i < 5; i++) {
            new Car(parking).start();
        }
    }
}
