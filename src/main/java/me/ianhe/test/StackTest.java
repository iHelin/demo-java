package me.ianhe.test;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
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
