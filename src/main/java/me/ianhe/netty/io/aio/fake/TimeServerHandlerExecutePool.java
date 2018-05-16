package me.ianhe.netty.io.aio.fake;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author iHelin
 * @since 2018/5/15 20:25
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executorService;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPoolSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable task) {
        executorService.execute(task);
    }

}
