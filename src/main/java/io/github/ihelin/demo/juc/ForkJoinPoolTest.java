package io.github.ihelin.demo.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author iHelin
 * @since 2017/11/23 13:59
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 50000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    static class ForkJoinSumCalculate extends RecursiveTask<Long> {

        private static final long serialVersionUID = -259195479995561737L;
        private final long start;
        private final long end;

        /**
         * 临界值
         */
        private static final long THRESHOLD = 10000L;

        public ForkJoinSumCalculate(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long length = end - start;
            if (length <= THRESHOLD) {
                long sum = 0L;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                long middle = (start + end) / 2;
                ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
                left.fork(); //进行拆分，同时压入线程队列
                ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
                right.fork(); //
                return left.join() + right.join();
            }
        }

    }

}

