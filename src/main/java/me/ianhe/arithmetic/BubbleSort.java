package me.ianhe.arithmetic;

import java.util.Arrays;

/**
 * 冒泡排序
 * 按从大到小排列
 *
 * @author iHelin
 * @since 2017/8/3 17:03
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "轮排序结果：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 7, 8, 4, 5, 3, 1, 2};
        sort(arr);
        System.out.println("最终结果：" + Arrays.toString(arr));
    }
}
