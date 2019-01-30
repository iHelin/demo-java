package me.ianhe.test;

/**
 * @author iHelin
 * @date 2019-01-19 14:57
 */
public class Test5 {


    public static void main(String[] args) {
        long a = 2;
        int c = 1;
        while (a < 390000000000L) {
            a *= 2;
            c++;
        }
        System.out.println(c);
    }
}
