package me.ianhe.arithmetic.pat.b1019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/2/26 14:22
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int res = run(number);
        while (res != 6174) {
            res = run(res);
        }
    }

    private static int run(int number) {
        int qian = number / 1000;
        int bai = (number - qian * 1000) / 100;
        int shi = (number - qian * 1000 - bai * 100) / 10;
        int ge = number - qian * 1000 - bai * 100 - shi * 10;
        List<Integer> list = new ArrayList<>();
        list.add(qian);
        list.add(bai);
        list.add(shi);
        list.add(ge);
        Collections.sort(list);
        int max = 1000 * list.get(3) + 100 * list.get(2) + 10 * list.get(1) + list.get(0);
        int min = 1000 * list.get(0) + 100 * list.get(1) + 10 * list.get(2) + list.get(3);
        if (max == min) {
            System.out.printf("%s - %s = 0000\n", plus(max), plus(min));
            return 6174;
        } else {
            int res = max - min;
            System.out.printf("%s - %s = %s\n", plus(max), plus(min), res);
            return res;
        }
    }

    /**
     * 注意不足4位的情况，前面要补零
     *
     * @param num
     * @return
     */
    private static String plus(int num) {
        if (num < 10) {
            return "000" + num;
        } else if (num < 100) {
            return "00" + num;
        } else if (num < 1000) {
            return "0" + num;
        }
        return String.valueOf(num);
    }
}
