package io.github.ihelin.demo.other.arithmetic.pat.b1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author iHelin
 * @since 2018/2/5 16:01
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        String[] s = line.split(" ");
        BigInteger a = new BigInteger(s[0]);
        BigInteger b = new BigInteger(s[1]);
        BigInteger[] res = a.divideAndRemainder(b);
        System.out.println(res[0] + " " + res[1]);
    }
}
