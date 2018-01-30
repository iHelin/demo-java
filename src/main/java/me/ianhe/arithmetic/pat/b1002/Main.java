package me.ianhe.arithmetic.pat.b1002;

import java.util.Scanner;

/**
 * 1002. 写出这个数 (20)
 * <p>
 * 时间限制
 * 400 ms
 * 内存限制
 * 65536 kB
 * 代码长度限制
 * 8000 B
 * 判题程序
 * Standard
 * 作者
 * CHEN, Yue
 * 读入一个自然数n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 * <p>
 * 输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。这里保证n小于10100。
 * <p>
 * 输出格式：在一行内输出n的各位数字之和的每一位，拼音数字间有1 空格，但一行中最后一个拼音数字后没有空格。
 * <p>
 * 输入样例：
 * 1234567890987654321123456789
 * 输出样例：
 * yi san wu
 *
 * @author iHelin
 * @since 2018/1/30 10:05
 */
public class Main {

    /**
     * 注意此题好像不能用String.split()来做
     *
     * @author iHelin
     * @since 2018/1/30 16:18
     */
    public static void main(String[] args) {
        String[] pingyins = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next().trim();
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - 48;
        }
        String s = String.valueOf(sum);
        for (int i = 0; i < s.length() - 1; i++) {
            System.out.print(pingyins[s.charAt(i) - 48] + " ");
        }
        System.out.print(pingyins[s.charAt(s.length() - 1) - 48]);
    }
}
