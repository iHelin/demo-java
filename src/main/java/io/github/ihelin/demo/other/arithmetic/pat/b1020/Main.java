package io.github.ihelin.demo.other.arithmetic.pat.b1020;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author iHelin
 * @since 2018/2/26 15:07
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        List<Mooncake> list = new ArrayList<>();
        Mooncake model;
        for (int i = 0; i < N; i++) {
            model = new Mooncake();
            model.count = scanner.nextInt();
            list.add(model);
        }

        for (int i = 0; i < N; i++) {
            list.get(i).price = scanner.nextInt();
            list.get(i).profit = list.get(i).price * 1.0 / list.get(i).count;
        }

        Collections.sort(list, new Comparator<Mooncake>() {
            @Override
            public int compare(Mooncake o1, Mooncake o2) {
                double profitA = o1.getProfit();
                double profitB = o2.getProfit();
                return Double.compare(profitB, profitA);
            }
        });

        double result = 0.0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < N; i++) {
                if (D >= list.get(i).count) {
                    result += list.get(i).price;
                    D -= list.get(i).count;
                } else if (D < list.get(i).count) {
                    result += D * list.get(i).profit;
                    flag = false;
                    break;
                }
            }
        }
        DecimalFormat df = new DecimalFormat("###.00");
        System.out.println(df.format(result));
    }


    static class Mooncake {
        int count;
        int price;
        double profit;

        public double getProfit() {
            return profit;
        }
    }
}
