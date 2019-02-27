package me.ianhe.other.arithmetic.pat.b1026;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:34
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();

        float temp = (c2 - c1) * 1.0f / 100;
        int time = Math.round(temp);
        int hour = time / 3600;
        time = time - hour * 3600;
        int min = time / 60;
        time = time - min * 60;
        int second = time;

        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append(0);
        }
        sb.append(hour);
        sb.append(":");
        if (min < 10) {
            sb.append(0);
        }
        sb.append(min);
        sb.append(":");
        if (second < 10) {
            sb.append(0);
        }
        sb.append(second);
        System.out.println(sb.toString());
    }
}
