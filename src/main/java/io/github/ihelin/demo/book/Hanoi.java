package io.github.ihelin.demo.book;

/**
 * 汉诺塔-递归
 *
 * @author iHelin
 * @since 2019-01-19 14:34
 */
public class Hanoi {

    private static int count = 0;

    private static void hanoi(int n, char x, char y, char z) {
        if (n == 0) {

        } else {

            hanoi(n - 1, x, z, y);
            System.out.println(++count + ":" + x + "=>" + y);
            hanoi(n - 1, z, y, x);
        }
    }

    public static void main(String[] args) {
        hanoi(6, 'A', 'B', 'C');
    }
}
