package io.github.ihelin.demo.test;

import java.text.NumberFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * @author iHelin
 * @since 2017/11/20 18:16
 */
public class Test4 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(NumberFormat.getAvailableLocales()));
        System.out.println(NumberFormat.getNumberInstance().format(0.98));
        System.out.println(NumberFormat.getInstance().format(0.98));
        System.out.println(NumberFormat.getCurrencyInstance().format(0.98));
        System.out.println(Date.from(Instant.ofEpochMilli(System.currentTimeMillis())));
        Calendar c = Calendar.getInstance();
    }

}
