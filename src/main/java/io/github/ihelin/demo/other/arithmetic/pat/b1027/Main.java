package io.github.ihelin.demo.other.arithmetic.pat.b1027;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:37
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        double temp = Math.pow((N + 1) * 1.0 / 2, 0.5);
        int n = (int) temp;

        for (int i = n; i > 1; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {
                //每行要打印的符号的个数（相对于前一行多两个）
                System.out.print(str);
            }
            System.out.println();   //换行打印
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {
                //每行要打印的符号的个数（相对于前一行多两个）
                System.out.print(str);
            }
            //换行打印
            System.out.println();
        }
        int sum = N - (2 * n * n - 1);
        System.out.println(sum);
    }
}
