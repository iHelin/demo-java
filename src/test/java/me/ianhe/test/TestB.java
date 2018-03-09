package me.ianhe.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iHelin
 * @since 2018/3/9 11:33
 */
public class TestB {

//    @SuppressWarnings(value ="unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(20);
        List<String> ls = list;
        System.out.println(ls.get(0));
    }

}
