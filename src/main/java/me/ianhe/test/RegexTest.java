package me.ianhe.test;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则测试
 *
 * @author iHelin
 * @since 2017/11/20 18:03
 */
public class RegexTest {

    public static void main(String[] args) throws ParseException {
        String str = "regre105 dfewfewgverb";
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        System.out.println(m.replaceAll("").trim());
        System.out.println(str.replaceAll("[^0-9]", ""));
    }

}
