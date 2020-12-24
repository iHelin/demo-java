package io.github.ihelin.demo.other.snowflake;

import com.relops.snowflake.Snowflake;

/**
 * @author iHelin
 * @date 2018-12-24 09:09
 */
public class Test {

    public static void main(String[] args) {
        int node = 1;
        Snowflake s = new Snowflake(node);
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.next());
    }
}
