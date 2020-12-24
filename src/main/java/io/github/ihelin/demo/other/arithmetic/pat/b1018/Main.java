package io.github.ihelin.demo.other.arithmetic.pat.b1018;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/2/5 16:07
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        int win = 0;
        int ping = 0;
        int loss = 0;
        int ccount = 0;
        int jcount = 0;
        int bcount = 0;
        int bccount = 0;
        int bjcount = 0;
        int bbcount = 0;
        for (int i = 0; i < count; i++) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            if (s[0].equals(s[1])) {
                ping++;
                continue;
            }
            if ("C J".equals(line) || "J B".equals(line) || "B C".equals(line)) {
                win++;
                if (line.startsWith("C")) {
                    ccount++;
                } else if (line.startsWith("J")) {
                    jcount++;
                } else {
                    bcount++;
                }
            } else {
                loss++;
                if (line.endsWith("C")) {
                    bccount++;
                } else if (line.endsWith("J")) {
                    bjcount++;
                } else {
                    bbcount++;
                }
            }
        }
        System.out.println(win + " " + ping + " " + loss);
        System.out.println(loss + " " + ping + " " + win);
        if (ccount > bcount) {
            if (ccount > jcount) {
                System.out.print("C ");
            } else if (ccount < jcount) {
                System.out.print("J ");
            } else {
                System.out.print("C ");
            }
        } else if (ccount < bcount) {
            if (bcount > jcount) {
                System.out.print("B ");
            } else if (bcount < jcount) {
                System.out.print("J ");
            } else {
                System.out.print("B ");
            }
        } else {
            if (jcount > ccount) {
                System.out.print("J ");
            } else {
                System.out.print("B ");
            }
        }

        if (bccount > bbcount) {
            if (bccount > bjcount) {
                System.out.print("C");
            } else if (bccount < bjcount) {
                System.out.print("J");
            } else {
                System.out.print("C");
            }
        } else if (bccount < bbcount) {
            if (bbcount > bjcount) {
                System.out.print("B");
            } else if (bbcount < bjcount) {
                System.out.print("J");
            } else {
                System.out.print("B");
            }
        } else {
            if (bjcount > bbcount) {
                System.out.print("J");
            } else {
                System.out.print("B");
            }
        }
    }

}
