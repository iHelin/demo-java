package io.github.ihelin.demo.other.arithmetic.pat.b1006;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/1/31 12:08
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int bai = number / 100;
        int shi = number % 100 / 10;
        int ge = number % 10;
        while (bai-- > 0) {
            System.out.print("B");
        }
        while (shi-- > 0) {
            System.out.print("S");
        }
        for (int i = 1; i <= ge; i++) {
            System.out.print(i);
        }
    }
}
