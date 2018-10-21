package me.ianhe.core;

import java.math.BigDecimal;

/**
 * @author iHelin
 * @date 2018/10/20 10:51
 */
public class Base {

    public static void main(String[] args) {
        //Double.POSITIVE_INFINITY
        System.out.println("1.0 / 0 = " + 1.0 / 0);
        //Double.NaN
        System.out.println("0.0 / 0 = " + 0.0 / 0);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN);
        //从Java 7开始。可以为数字字面量加下划线
        System.out.println(1_224_134);
        System.out.println(2.0 - 1.9);
        System.out.println(BigDecimal.valueOf(2.0).subtract(BigDecimal.valueOf(1.9)));
        System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("1.9")));
    }
}
