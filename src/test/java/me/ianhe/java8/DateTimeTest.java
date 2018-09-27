package me.ianhe.java8;

import org.junit.Test;

import java.io.IOException;
import java.time.*;

/**
 * @author iHelin
 * @since 2018/3/9 17:13
 */
public class DateTimeTest {

    @Test
    public void test() throws IOException {
        System.out.println("1.0 / 0 :" + 1.0 / 0);//Double.POSITIVE_INFINITY
        System.out.println("0.0 / 0 :" + 0.0 / 0);//Double.NaN
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN);
        System.out.println(1_224_134);
        System.out.println("MonthDay.now() :" + MonthDay.now());
        System.out.println("Instant.now() :" + Instant.now());
        System.out.println("Year.now() :" + Year.now());
        System.out.println("YearMonth.now() :" + YearMonth.now());
        System.out.println("DayOfWeek.FRIDAY :" + DayOfWeek.FRIDAY);
        Clock clock = Clock.systemUTC();
        System.out.println("Clock.systemUTC() :" + clock.instant());
    }

}
