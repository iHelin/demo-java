package io.github.ihelin.demo.other.arithmetic.pat.b1010;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/2/1 16:15
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split("\\s+");
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i = i + 2) {
            int a = Integer.valueOf(words[i]);
            int b = Integer.valueOf(words[i + 1]);
            if (a == 0) {
                res.add(0);
                res.add(0);
            }
            if (a != 0 && b != 0) {
                res.add(a * b);
                res.add(b - 1);
            }
        }
        if (res.isEmpty()) {
            System.out.print("0 0");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
