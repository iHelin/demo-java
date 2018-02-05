package me.ianhe.arithmetic.pat.b1008;

import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/1/31 13:53
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int index = N - (M % N);
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        if (N == 1) {
            System.out.print(array[0]);
        } else {
            System.out.print(array[index % N] + " ");
            int originalIndex = index;
            index++;
            while ((index % N) != (originalIndex % N)) {
                if ((index % N) == ((originalIndex - 1) % N)) {
                    System.out.print(array[index % N]);
                } else {
                    System.out.print(array[index % N] + " ");
                }
                index++;
            }
        }
    }
}
