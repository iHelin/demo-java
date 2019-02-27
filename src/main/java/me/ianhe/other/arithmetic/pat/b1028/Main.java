package me.ianhe.other.arithmetic.pat.b1028;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:43
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Person p = new Person();
            p.name = sc.next();
            p.setDateStr(sc.next());
            list.add(p);
        }

        int count = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        String maxName = "";
        String minName = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).date >= 18140906 && list.get(i).date <= 20140906) {
                count++;
                if (list.get(i).date < max) {
                    max = list.get(i).date;
                    maxName = list.get(i).name;
                }

                if (list.get(i).date > min) {
                    min = list.get(i).date;
                    minName = list.get(i).name;
                }
            }

        }
        System.out.println(count + " " + maxName + " " + minName);
    }

    static class Person {
        String name;
        int date;
        String dateStr;

        public void setDateStr(String dateStr) {
            this.dateStr = dateStr;
            String[] str = dateStr.split("/");
            this.date = Integer.parseInt(str[0]) * 10000
                    + Integer.parseInt(str[1]) * 100 + Integer.parseInt(str[2]);
        }
    }
}
