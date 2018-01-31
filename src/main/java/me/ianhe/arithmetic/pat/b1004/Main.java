package me.ianhe.arithmetic.pat.b1004;

import java.util.Scanner;

/**
 * 1004. 成绩排名 (20)
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
 * 读入n名学生的姓名、学号、成绩，分别输出成绩最高和成绩最低学生的姓名和学号。
 * <p>
 * 输入格式：每个测试输入包含1个测试用例，格式为
 * <p>
 * 第1行：正整数n
 * 第2行：第1个学生的姓名 学号 成绩
 * 第3行：第2个学生的姓名 学号 成绩
 * ... ... ...
 * 第n+1行：第n个学生的姓名 学号 成绩
 * 其中姓名和学号均为不超过10个字符的字符串，成绩为0到100之间的一个整数，这里保证在一组测试用例中没有两个学生的成绩是相同的。
 * 输出格式：对每个测试用例输出2行，第1行是成绩最高学生的姓名和学号，第2行是成绩最低学生的姓名和学号，字符串间有1空格。
 * <p>
 * 输入样例：
 * 3
 * Joe Math990112 89
 * Mike CS991301 100
 * Mary EE990830 95
 * 输出样例：
 * Mike CS991301
 * Joe Math990112
 *
 * @author iHelin
 * @since 2018/1/30 16:58
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] student = new String[n];
        int maxIndex = 0;
        int minIndex = 0;
        int maxS = 0;
        int minS = 100;
        for (int i = 0; i < n; i++) {
            student[i] = scanner.nextLine().trim();
            String[] a = student[i].split("\\s+");
            int scout = Integer.valueOf(a[2]);
            if (scout > maxS) {
                maxS = scout;
                maxIndex = i;
            }
            if (scout < minS) {
                minS = scout;
                minIndex = i;
            }
        }
        String[] max = student[maxIndex].split("\\s+");
        System.out.println(max[0] + " " + max[1]);
        String[] min = student[minIndex].split("\\s+");
        System.out.println(min[0] + " " + min[1]);
    }
}
