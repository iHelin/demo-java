package me.ianhe.arithmetic.pat.b1024;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:26
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigDecimal s = scan.nextBigDecimal();
        System.out.println(s.toPlainString());
        scan.close();
    }
}
