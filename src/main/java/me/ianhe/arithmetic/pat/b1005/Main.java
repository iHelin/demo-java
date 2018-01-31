package me.ianhe.arithmetic.pat.b1005;

import java.util.*;

/**
 * @author iHelin
 * @since 2018/1/31 11:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();
        String[] numStr = s.split("\\s+");
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.valueOf(numStr[i]);
        }
        Set<Integer> yinzi = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numArr.length; i++) {
            int number = numArr[i];
            while (number != 1) {
                if ((number & 1) != 0) {
                    number = (3 * number + 1) >> 1;
                } else {
                    number = number >> 1;
                }
                yinzi.add(number);
            }
        }
        for (int i = 0; i < numArr.length; i++) {
            if (!yinzi.contains(numArr[i])) {
                result.add(numArr[i]);
            }
        }
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
