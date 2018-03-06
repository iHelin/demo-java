package me.ianhe.arithmetic.pat.b1040;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 10:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        int countT = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'T') {
                countT++;
            }
        }
        int countP = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'P') {
                countP++;
            }
            if (chars[i] == 'T') {
                countT--;
            }
            if (chars[i] == 'A') {
                result = (result + (countP * countT) % 1000000007) % 1000000007;
            }
        }

        System.out.println(result);
    }
}
