package io.github.ihelin.demo.other.arithmetic.pat.b1014;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 很有可能超时，要改进
 *
 * @author iHelin
 * @since 2018/2/2 17:04
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String s3 = bufferedReader.readLine();
        String s4 = bufferedReader.readLine();
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] time = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        System.out.print(day[getFirstUppercase(s1, s2)] + " ");
        System.out.printf("%02d:", time[getSecondUppercase(s1, s2)]);
        System.out.printf("%02d\n", getfz(s3, s4));

    }

    private static int getFirstUppercase(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (isUppercase1(s1, i)) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    return s1.charAt(i) - 65;
                }
            }
        }
        return 0;
    }

    public static int get(String s1, String s2) {
        int k = getFirstUppercase(s1, s2) + 65;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == k) {
                return i;
            }
        }
        return 0;
    }

    private static int getSecondUppercase(String s1, String s2) {
        int len1 = s1.length();
        for (int i = get(s1, s2) + 1; i < len1; i++) {
            if (Character.isDigit(s1.charAt(i))) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    return s1.charAt(i) - 48;
                }
            }
            if (isUppercase2(s1, i)) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    return s1.charAt(i) - 55;
                }
            }
        }
        return 0;
    }


    private static int getfz(String s1, String s2) {
        int len1 = s1.length();
        for (int i = 0; i < len1; i++) {
            if (Character.isAlphabetic(s1.charAt(i))) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private static boolean isUppercase1(String s, int i) {
        return s.charAt(i) >= 65 && s.charAt(i) <= 71;
    }

    private static boolean isUppercase2(String s, int i) {
        return (s.charAt(i) >= 65 && s.charAt(i) <= 78);
    }

}
