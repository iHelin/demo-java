package io.github.ihelin.demo.other.arithmetic.pat.b1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 注意：1、正则比较耗时
 * 2、Scanner比BufferedReader耗时，尽量用BufferedReader
 *
 * @author iHelin
 * @since 2018/2/1 17:32
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] strNums = line.split(" ");
        int a1 = 0, A2 = 0, A3 = 0, A5 = 0, countA4 = 0, sumA4 = 0, j = 0;
        boolean existA2 = false;
        for (int i = 1; i < strNums.length; i++) {
            int num = Integer.valueOf(strNums[i]);
            if (num % 10 == 0) {
                a1 += num;
            } else if (num % 5 == 1) {
                A2 += num * (int) Math.pow(-1, j);
                existA2 = true;
                j++;
            } else if (num % 5 == 2) {
                A3++;
            } else if (num % 5 == 3) {
                sumA4 += num;
                countA4++;
            } else if (num % 5 == 4) {
                A5 = A5 > num ? A5 : num;
            }
        }
        if (a1 != 0) {
            System.out.print(a1 + " ");
        } else {
            System.out.print("N ");
        }
        if (existA2) {
            System.out.print(A2 + " ");
        } else {
            System.out.print("N ");
        }
        if (A3 != 0) {
            System.out.print(A3 + " ");
        } else {
            System.out.print("N ");
        }
        if (countA4 != 0) {
            double avg = (double) sumA4 / countA4;
            System.out.print(Math.round(avg * 10) / 10.0 + " ");
        } else {
            System.out.print("N ");
        }
        if (A5 != 0) {
            System.out.println(A5);
        } else {
            System.out.println("N");
        }
    }
}
