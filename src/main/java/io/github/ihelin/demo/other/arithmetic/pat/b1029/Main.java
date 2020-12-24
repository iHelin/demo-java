package io.github.ihelin.demo.other.arithmetic.pat.b1029;

import java.util.*;

/**
 * @author iHelin
 * @since 2018/3/6 09:44
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String old = sc.next();
        String result = sc.next();

        Map<Character, Integer> mapResult = new HashMap<>();
        Map<Character, Integer> mapOld = new HashMap<>();

        char[] charsResult = result.toUpperCase().toCharArray();
        char[] charsOld = old.toUpperCase().toCharArray();

        for (int i = 0; i < charsResult.length; i++) {
            if (!mapResult.containsKey(charsResult[i])) {
                mapResult.put(charsResult[i], i);
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < charsOld.length; i++) {
            if (!mapResult.containsKey(charsOld[i])) {
                if (!mapOld.containsKey(charsOld[i])) {
                    mapOld.put(charsOld[i], i);
                    list.add(charsOld[i]);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
