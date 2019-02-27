package me.ianhe.java8;

import com.google.common.collect.ImmutableList;

import java.util.StringJoiner;

/**
 * @author iHelin
 * @date 2019-02-27 09:49
 */
public class StringJoinerTest {


    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner("Hollis");
        joiner.add("hollischuang");
        joiner.add("Java干货");
        System.out.println(joiner.toString());

        StringJoiner sj1 = new StringJoiner(":", "[", "]");

        sj1.add("Hollis").add("hollischuang").add("Java干货");
        System.out.println(sj1.toString());

        ImmutableList<String> objects = ImmutableList.of("Hollis", "hollischuang", "Java干货");
//        List<String> objects = Arrays.asList("Hollis", "hollischuang", "Java干货");


        String s = String.join(":", objects);
        System.out.println(s);
    }
}
