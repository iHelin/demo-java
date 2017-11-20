package me.ianhe.test;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author iHelin
 * @since 2017/11/20 18:16
 */
public class Test3 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
        BigInteger i = BigInteger.probablePrime(10, random);
        System.out.println(i);
        String b = "True";
        Boolean a = Boolean.valueOf(b);
        System.out.println(a);
    }

}
