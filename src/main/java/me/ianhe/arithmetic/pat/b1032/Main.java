package me.ianhe.arithmetic.pat.b1032;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author iHelin
 * @since 2018/3/6 09:50
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            int score = 0;
            if (map.containsKey(key)) {
                score += map.get(key) + value;
            } else {
                score = value;
            }
            map.put(key, score);
        }
 
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        int value = -1;
        int key = -1;
        while (entries.hasNext()) {
 
            Map.Entry<Integer, Integer> entry = entries.next();
            if (entry.getValue() > value) {
                value = entry.getValue();
                key = entry.getKey();
            }
        }
        System.out.println(key + " " + value);
    }
}
