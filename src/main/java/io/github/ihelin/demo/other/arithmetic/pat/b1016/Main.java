package io.github.ihelin.demo.other.arithmetic.pat.b1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author iHelin
 * @since 2018/2/5 15:49
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] s = line.split(" ");
        String a = s[0];
        int da = Integer.valueOf(s[1]);
        String b = s[2];
        int db = Integer.valueOf(s[3]);
        int suma = 0;
        int sumb = 0;
        for (int i = 0; i < a.length(); i++) {
            if (da == (a.charAt(i) - 48)) {
                suma = suma * 10 + da;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (db == (b.charAt(i) - 48)) {
                sumb = sumb * 10 + db;
            }
        }
        System.out.println(suma + sumb);
    }
}
