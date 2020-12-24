package io.github.ihelin.demo.test;

/**
 * 坑
 *
 * @author iHelin
 * @since 2017/11/20 18:16
 */
public class Test2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0L;
        /**
         * i <= Integer.MAX_VALUE 将进入死循环，不能包含等于
         */
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);
    }
}
