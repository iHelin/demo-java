package me.ianhe.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author iHelin
 * @date 2019-02-22 17:40
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
            final String runnerNameStr = String.valueOf(runnerName);
            new Thread(() -> {
                long prepareTime = random.nextInt(10000) + 100;
                System.out.println(runnerNameStr + " is preparing for time:" + prepareTime);
                try {
                    Thread.sleep(prepareTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(runnerNameStr + " is prepared, waiting for others");
                    cyclicBarrier.await(); // The current runner is ready, waiting for others to be ready
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(runnerNameStr + " starts running"); // All the runners are ready to start running together
            }).start();
        }
    }

}
