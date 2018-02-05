package me.ianhe.arithmetic.pat.b1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 注意：超时超时超时
 *
 * @author iHelin
 * @since 2018/2/2 16:31
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] strNums = line.split(" ");
        int m = Integer.valueOf(strNums[0]);
        int n = Integer.valueOf(strNums[1]);
        int count = 0;
        int i = 2;
        List<Integer> res = new ArrayList<>();
        while (true) {
            if (isPrime(i)) {
                count++;
                if (count > n) {
                    break;
                }
                if (count >= m && count <= n) {
                    res.add(i);
                }
            }
            i++;
        }
        for (int j = 0; j < res.size(); j++) {
            System.out.print(res.get(j));
            if (j % 10 == 9) {
                System.out.println();
            } else {
                if (j != res.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
