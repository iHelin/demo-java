package io.github.ihelin.demo.other.arithmetic.pat.b1021;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/2/27 19:34
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[10];
        String n = scanner.next();
        for (int i = 0; i < n.length(); i++) {
            a[n.charAt(i) - 48]++;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                System.out.println(i + ":" + a[i]);
            }
        }
    }
}
