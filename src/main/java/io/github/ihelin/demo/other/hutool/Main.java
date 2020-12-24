package io.github.ihelin.demo.other.hutool;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] b = {"1", "2", "3", "4"};
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
        System.out.println(Arrays.toString(intArray));

        long[] c = {1, 2, 3, 4, 5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        System.out.println(Arrays.toString(intArray2));
    }

}
