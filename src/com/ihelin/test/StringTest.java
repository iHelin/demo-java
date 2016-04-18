package com.ihelin.test;

import java.util.LinkedList;
import java.util.List;

public class StringTest {

	public static void main(String[] args) {
		String s = "0123456789";
		System.out.println(s.length());
		System.out.println(s.charAt(4));
		char a = 'c';
		System.out.println(a);
		char[] b = { '1', '2' };
		System.out.println(b.hashCode());
		char[] c = b.clone();
		System.out.println(c);

		List<String> aList = new LinkedList<String>();
		aList.add("121345rt");
		aList.add("wqe");
		aList.add("dfs");
		System.out.println(aList);

		
	}

}
