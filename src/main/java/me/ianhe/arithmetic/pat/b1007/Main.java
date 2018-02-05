package me.ianhe.arithmetic.pat.b1007;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1007. 素数对猜想 (20)
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
 * 让我们定义 dn 为：dn = pn+1 - pn，其中 pi 是第i个素数。显然有 d1=1 且对于n>1有 dn 是偶数。“素数对猜想”认为“存在无穷多对相邻且差为2的素数”。
 * <p>
 * 现给定任意正整数N (< 105)，请计算不超过N的满足猜想的素数对的个数。
 * <p>
 * 输入格式：每个测试输入包含1个测试用例，给出正整数N。
 * <p>
 * 输出格式：每个测试用例的输出占一行，不超过N的满足猜想的素数对的个数。
 * <p>
 * 输入样例：
 * 20
 * 输出样例：
 * 4
 *
 * @author iHelin
 * @since 2018/1/31 13:31
 */
public class Main {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(getPrimePair(num));
        scanner.close();

    }

    private static int getPrimePair(int num) {
        int primePairNum = 0;
        int n = 0;
        for (int index = 2; index <= num; index++) {
            if (isPrime(index)) {
                list.add(index);
                n++;
                if (n > 1 && index - list.get(n - 2) == 2) {
                    primePairNum++;
                }
            }
        }
        return primePairNum;
    }

    /**
     * 判断是否是素数（质数）
     *
     * @author iHelin
     * @since 2018/1/31 13:33
     */
    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
