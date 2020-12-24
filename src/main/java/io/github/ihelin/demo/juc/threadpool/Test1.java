package io.github.ihelin.demo.juc.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {


    private static final AtomicInteger count = new AtomicInteger(0);//线程计数
    private static final int corePoolSize = 2;//核心线程数
    private static final int maximumPoolSize = 4;//最大线程数。可以计算，非核心线程数 = maximumPoolSize - corePoolSize = 2
    private static final long keepAliveTime = 10;//非核心空闲线程最长存活时间
    private static final TimeUnit timeUnit = TimeUnit.SECONDS;//非核心空闲线程最长存活时间的单位
    //指定阻塞队列的类型和队列长度。可以计算，被核心线程数同时处理的任务个数 = corePoolSize + 队列容量 = 2 + 2 = 4
    private static final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
    //定义线程工厂
    private static final ThreadFactory myThreadFactory = runnable -> {
        String threadName = "线程" + count.addAndGet(1);
        return new Thread(runnable, threadName);
    };
    //定义任务拒绝执行的策略
    private static final RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 记录异常
            // 报警处理等
            int iActiveCount = executor.getActiveCount();
            int iRemainQueue = executor.getQueue().remainingCapacity();
            int iExistQueue = executor.getQueue().size();
            System.out.println("Warn:当前运行的线程数:" + iActiveCount +
                    ",当前队列剩余数:" + iRemainQueue +
                    ",当前队列排队的任务数:" + iExistQueue);
        }
    };

    /**
     * 2.使用线程池
     * 创建7个任务: 根据线程池的初始化参数配置可推测：
     * （1）2个任务立即执行；
     * （2）2个任务加入到阻塞队列中等待核心线程执行；
     * （3）2个任务被2个非核心线程执行；
     * （4）剩下的1个任务没有线程来执行(被拒绝执行),因此调用【拒绝执行策略】来处理。
     */
    public static void main(String[] args) {
        //1.初始化线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                timeUnit,
                workQueue,
                myThreadFactory,
                rejectedExecutionHandler
        );

        for (int i = 0; i < 7; i++) {
            //执行任务
            final int finalI = i;
            executor.execute(() -> {
                System.out.println(finalI + "当前执行任务的线程名:" + Thread.currentThread().getName());
                long start = System.currentTimeMillis();
                while (true) {
                    long end = System.currentTimeMillis();
                    if ((end - start) > 10000) {//10秒
                        break;
                    }
                }
            });
        }
    }
}
