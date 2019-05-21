package me.ianhe.basic;

import java.util.Deque;
import java.util.Stack;

/**
 * @author iHelin
 * @see Deque
 * @since 2017/11/20 18:06
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("123");
        s.push("234");
        s.push("345");
        s.push("456");
        s.push("567");
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.peek());
    }

}
