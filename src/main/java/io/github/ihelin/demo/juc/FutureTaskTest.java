package io.github.ihelin.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 使用FutureTask模拟开会
 *
 * @author iHelin
 * @since 2018/10/2 09:22
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            FutureTask<String> futureTask = new FutureTask<>(new EmployeeThread());
            new Thread(futureTask, "员工" + i).start();
            try {
                String res = futureTask.get();
                System.out.println(res);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("所有人都已经到齐了，开会吧...");

    }

    static class EmployeeThread implements Callable<String> {
        @Override
        public String call() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            return Thread.currentThread().getName() + " 到达会议室....";
        }

    }
}
