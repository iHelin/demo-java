package me.ianhe.test;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/12 22:54
 */
public class AZTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getKey(scanner.nextInt()));
    }

    public static String getKey(int index) {
        String colCode = "";
        char key = 'A';
        int loop = index / 26;
        if (loop > 0) {
            colCode += getKey(loop - 1);
        }
        key = (char) (key + index % 26);
        colCode += key;
        return colCode;
    }
}
