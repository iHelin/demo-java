package io.github.ihelin.demo.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @author iHelin
 * @since 2019/9/9 14:28
 */
public class LongStreamTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0L; i <= 50000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("test1 耗费时间为：" + Duration.between(start, end).toMillis());
    }

    /**
     * java8 新特性
     */
    private static void test2() {
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L, 50000000000L)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("test2 耗费时间为：" + Duration.between(start, end).toMillis());
    }
}
