package me.ianhe.arithmetic.pat.b1039;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 10:14
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String my = in.next();
        int[] arr = new int[62];
        for (int i = 0; i < my.length(); i++) {
            arr[index(my.charAt(i))]++;
        }
        for (int i = 0; i < a.length(); i++) {
            arr[index(a.charAt(i))]--;
        }
        int need = my.length();
        int miss = 0;
        for (int i = 0; i < my.length(); i++) {
            int index = index(my.charAt(i));
            if (arr[index] <= 0) {
                need--;
            } else {
                miss += arr[index];
                arr[index] = 0;
            }
        }
        if (need == 0) {
            need = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    need += -arr[i];
                }
            }
            System.out.println("Yes" + " " + need);
        } else {
            System.out.println("No" + " " + miss);
        }

    }

    private static int index(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        if (c >= 'A' && c <= 'Z') {
            return 26 + c - 'A';
        }
        if (c >= '0' && c <= '9') {
            return 26 + 26 + c - '0';
        }
        return -1;
    }
}
