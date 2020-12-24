package io.github.ihelin.demo.other.arithmetic.pat.b1022;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/2/27 19:42
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int d = scanner.nextInt();
        int c = a + b;
        StringBuilder str = new StringBuilder();
        while (c > 0) {
            int temp = c % d;
            str.insert(0, temp);
            c = c / d;
        }
        System.out.print(str);
    }
}
