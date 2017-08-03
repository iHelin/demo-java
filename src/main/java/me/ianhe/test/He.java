package me.ianhe.test;

/**
 * 1+3+5+7+……+99求和
 *
 * @author iHelin
 * @since 2017/8/3 16:52
 */
public class He {

    public static void main(String[] args) {
        int sum = 0;
        for (int number = 1; number < 100; number += 2) {
            sum += number;
        }
        System.out.println("1+3+5+7+……+99= " + sum);

    }

}
