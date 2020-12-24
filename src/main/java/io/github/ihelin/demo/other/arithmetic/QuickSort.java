package io.github.ihelin.demo.other.arithmetic;

import java.util.Arrays;

/**
 * @author iHelin
 * @since 2017/8/3 17:05
 */
public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // 基准值（第一个数值作为基准值）
            int base = arr[start];
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((arr[i] < base) && (i < end)) {
                    i++;
                }
                while ((arr[j] > base) && (j > start)) {
                    j--;
                }
                if (i <= j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                quickSort(arr, start, j);
            }
            if (end > i) {
                quickSort(arr, i, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
