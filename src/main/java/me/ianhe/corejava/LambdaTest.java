package me.ianhe.corejava;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author iHelin
 * @date 2018/10/26 11:33
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add(null);
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("null");
        list.add("3");
        list.removeIf(x -> Objects.equals(x, "2"));
        System.out.println(Arrays.toString(list.toArray()));
    }
}
