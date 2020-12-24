package io.github.ihelin.demo.other.arithmetic.pat.b1033;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:57
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brokenStr = sc.next();
        String oldStr = sc.next();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < oldStr.length(); i++) {
            if (canShow(brokenStr, oldStr.charAt(i))) {
                char ch = oldStr.charAt(i);
                sb.append(ch);
                count++;
            }
        }
        if (count == 0) {
            System.out.println();
        } else {
            System.out.print(sb.toString());
        }

    }

    public static boolean canShow(String brokenStr, char ch) {
        if (brokenStr.indexOf(Character.toUpperCase(ch)) >= 0 || brokenStr.indexOf(Character.toLowerCase(ch)) >= 0) {
            return false;
        }
        return brokenStr.indexOf('+') < 0 || ch - 'A' < 0 || ch - 'A' > 25;
    }
}
