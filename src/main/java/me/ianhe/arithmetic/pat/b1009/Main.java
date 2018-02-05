package me.ianhe.arithmetic.pat.b1009;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/1/31 14:24
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split("\\s+");
        String[] newWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            newWords[i] = words[words.length - i - 1];
        }
        for (int i = 0; i < newWords.length; i++) {
            System.out.print(newWords[i]);
            if (i != newWords.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
