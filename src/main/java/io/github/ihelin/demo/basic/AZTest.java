package io.github.ihelin.demo.basic;

import java.util.Scanner;

/**
 * 输入数字，返回对应的英文
 *
 * @author iHelin
 * @since 2018/3/12 22:54
 */
public class AZTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getKey(scanner.nextInt()));
    }

    private static String getKey(int index) {
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
