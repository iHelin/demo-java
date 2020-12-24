package io.github.ihelin.demo.other.arithmetic.pat.b1038;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 10:10
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            //用以存储每个分数段的人数。
            int[] num = new int[101];
            for (int i = 0; i < N; i++) {
                num[sc.nextInt()]++;
            }
            int K = sc.nextInt();
            for (int i = 0; i < K; i++) {
                System.out.print(num[sc.nextInt()]);
                if (i != K - 1) {
                    System.out.print(" ");
                }
            }
        }
        sc.close();
    }
}
