package me.ianhe.test;

import java.util.Date;

public class Test5 {
	public static void main(String[] args) {
		Date s = new Date();
		long sum = 0L;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(new Date().getTime() - s.getTime());
	}
}
