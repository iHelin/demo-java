package me.ianhe.other.arithmetic.pat.b1031;

import java.util.*;

/**
 * @author iHelin
 * @since 2018/3/6 09:47
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        Map<Integer, String> vertify = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            if (i < 2) {
                vertify.put(i, String.valueOf(1 - i));
            } else if (i == 2) {
                vertify.put(i, "X");
            } else {
                vertify.put(i, String.valueOf(12 - i));
            }
        }
        int N = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.next());
        }
        List<String> errorList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 18) {
                if (list.get(i).contains("X")) {
                    if (list.get(i).charAt(17) == 'X') {
                        if (!vertify(list.get(i), weight, vertify)) {
                            errorList.add(list.get(i));
                        }
                    } else {
                        errorList.add(list.get(i));
                    }
                } else {
                    if (!vertify(list.get(i), weight, vertify)) {
                        errorList.add(list.get(i));
                    }
                }
            } else {
                errorList.add(list.get(i));
            }
        }
 
        if (errorList.size() == 0) {
            System.out.println("All passed");
        } else {
            for (int i = 0; i < errorList.size(); i++) {
                System.out.println(errorList.get(i));
            }
        }
 
    }
 
            public static boolean vertify(String id, int[] weight, Map<Integer, String> vertify) {
 
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            int temp = id.charAt(i) - '0';
            sum += temp * weight[i];
        }
 
        int result = sum % 11;
                return vertify.get(result).equals(String.valueOf(id.charAt(17)));
    }
}
