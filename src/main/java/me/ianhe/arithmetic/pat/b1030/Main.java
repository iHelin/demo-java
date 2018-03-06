package me.ianhe.arithmetic.pat.b1030;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:46
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + maxlen; j < n; j++) {
                if (arr[j] > arr[i] * p) {
                    break;
                }
                maxlen++;
            }

        }
        System.out.println(maxlen);
    }
}
