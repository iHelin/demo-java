package me.ianhe.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch ：闭锁
 * 在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行
 * 等待其他线程都完成后才开始
 *
 * @author iHelin
 * @since 2017/11/22 10:18
 */
public class CountDownLatchTest {

    static class EmployeeThread implements Runnable {

        private CountDownLatch latch;

        public EmployeeThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 到达会议室....");
                //员工到达会议室 count - 1
            } finally {
                latch.countDown();
            }

        }

    }

    /**
     * 老板等待员工开会示例
     *
     * @author iHelin
     * @since 2017/12/20 12:14
     */
    public static void main(String[] args) {
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        System.out.println("Boss在会议室等待，总共有" + count + "个人开会...");
        EmployeeThread latchDemo = new EmployeeThread(latch);
        for (int i = 0; i < count; i++) {
            new Thread(latchDemo, "员工" + i).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人都已经到齐了，开会吧...");
    }
}