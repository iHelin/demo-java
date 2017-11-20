package me.ianhe.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串压缩
 *
 * @author iHelin
 * @since 2017/11/20 16:25
 */
public class Test {

    public static void main(String[] args) {
        encode("");
        encode(null);
        encode("a");
        encode("abbcaabbaaaaaa");

        encode2("");
        encode2(null);
        encode2("a");
        encode2("abbcaabbaaaaaa");
    }

    public static void encode(String str) {
        if (str == null || "".equals(str)) {
            System.out.println("");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char element = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == element) {
                count++;
            } else {
                sb.append(element);
                sb.append(count == 1 ? "" : count);
                element = str.charAt(i);
                count = 1;
            }
        }
        sb.append(element);
        sb.append(count == 1 ? "" : count);

        System.out.println(sb.toString());
    }

    public static void encode2(String str) {
        if (str == null || "".equals(str)) {
            System.out.println("");
            return;
        }
        List<Integer> indexList = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                indexList.add(i);
            }
        }
        for (int i = 0; i < indexList.size(); i++) {
            if (i == 0) {
                System.out.print(str.charAt(indexList.get(i) - 1));
                int count = indexList.get(i);
                System.out.print(count == 1 ? "" : count);
            } else {
                System.out.print(str.charAt(indexList.get(i) - 1));
                int count = indexList.get(i) - indexList.get(i - 1);
                System.out.print(count == 1 ? "" : count);
            }
        }
        System.out.print(str.charAt(str.length() - 1));
        if (indexList.size() > 0) {
            System.out.print(str.length() - indexList.get(indexList.size() - 1));
        }
        System.out.println();
    }
}
