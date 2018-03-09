package me.ianhe.test;

import java.time.*;

/**
 * @author iHelin
 * @since 2018/3/6 21:23
 */
public class TestA {

    public static void main(String[] args) {
        System.out.println(1.0/0);
        System.out.println(0.0/0);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NaN);
        int a = 1_224_134;
        System.out.println(a);
        System.out.println(MonthDay.now());
        System.out.println(Instant.now());
        System.out.println(Year.now());
        System.out.println(YearMonth.now());
        System.out.println(DayOfWeek.FRIDAY);
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
    }
}
