package io.github.ihelin.demo.book;

import java.util.Random;

/**
 * 三目运算符可能碰到的坑
 *
 * @author iHelin
 * @since 2017/11/20 16:48
 */
public class TernaryOperator {

    public static void main(String[] args) {
        long i = 1L;
        /**
         * long i = 1l; l不要小写
         */
        System.out.println("i的两倍是：" + (i + i));

        int j = new Random().nextInt();
        System.out.println(j);

        int k = 80;
        String s = String.valueOf(k < 100 ? 90 : 100);
        /*
        这里实际上返回了90.0,java会先将两边转换为相同类型,所以尽量保证三元操作符中的两个操作数类型一致
         */
        String s1 = String.valueOf(k < 100 ? 90 : 100.0);
        System.out.println(s.equals(s1));
    }

}
