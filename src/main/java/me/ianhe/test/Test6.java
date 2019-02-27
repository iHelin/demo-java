package me.ianhe.test;

/**
 * 思路分析：把一个整数减去1，再和原来的整数做与运算，会把该整数最右边一个1变成0，
 * 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
 *
 * @author iHelin
 * @date 2019-02-27 15:50
 */
public class Test6 {


    public static void main(String[] args) {
        int number1 = 10;
        System.out.println("整数11的二进制中1的个数为:" + numberOfOne(number1));
        //Java中的int类型整数由4字节32位组成
        int number2 = -11;
        System.out.println("整数11的二进制中1的个数为:" + numberOfOne(number2));


    }

    private static int numberOfOne(int number) {
        int count = 0;

        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }
}
