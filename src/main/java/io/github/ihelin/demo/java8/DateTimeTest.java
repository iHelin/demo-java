package io.github.ihelin.demo.java8;

import java.time.*;
import java.util.Date;

/**
 * @author iHelin
 * @since 2018/3/9 17:13
 */
public class DateTimeTest {

    public static void main(String[] args) {
        System.out.println("MonthDay.now() :" + MonthDay.now());
        System.out.println("Instant.now() :" + Instant.now());
        System.out.println("Year.now() :" + Year.now());
        System.out.println("YearMonth.now() :" + YearMonth.now());
        System.out.println("DayOfWeek.FRIDAY :" + DayOfWeek.FRIDAY);
        Clock clock = Clock.systemUTC();
        System.out.println("Clock.systemUTC() :" + clock.instant());
        dateToInstant();
        instantToDate();
    }

    private static void dateToInstant() {
        Date now = new Date();
        Instant instant = now.toInstant();
        System.out.println(instant);
    }

    private static void instantToDate() {
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        System.out.println(date);
    }

}
