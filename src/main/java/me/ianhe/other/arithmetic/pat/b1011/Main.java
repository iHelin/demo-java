package me.ianhe.other.arithmetic.pat.b1011;

import java.util.Scanner;

/**
 * 注意溢出
 * int最大值2147483647
 *
 * @author iHelin
 * @since 2018/2/1 16:54
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] inputArray = new String[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextLine();
        }
        int i = 1;
        for (String s : inputArray) {
            String[] x = s.split("\\s+");
            long a = Long.valueOf(x[0]);
            long b = Long.valueOf(x[1]);
            long c = Long.valueOf(x[2]);
            System.out.println("Case #" + i + ": " + (a + b > c));
            i++;
        }
    }

}
