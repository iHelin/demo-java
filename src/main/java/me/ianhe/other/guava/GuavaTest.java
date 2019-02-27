package me.ianhe.other.guava;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * @author iHelin
 * @create 2017-04-15 10:07
 */
public class GuavaTest {

    /**
     * com.google.common.primitives.Ints工具类
     *
     * @author iHelin
     * @since 2017-05-10 15:30
     */
    public static void intTest() {
        int[] intArray = {10, 20, 30, 9, 40, 80};
        System.out.println(Ints.max(intArray));
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        intArray = Ints.toArray(list);
        System.out.println(Ints.max(intArray));
    }

    public static void main(String[] args) {
        intTest();
    }

}
