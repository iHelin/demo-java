package me.ianhe.www;

import java.util.Random;

public class Demo1 {
	public static void main(String[] args) {
		long i = 1L;
		//long i = 1l; 不要这样写
		System.out.println("i的两倍是："+(i+i));
		
		int j = new Random().nextInt();
		System.out.println(j);
		
		int k = 80;
		String s = String.valueOf(k<100?90:100);
		String s1 = String.valueOf(k<100?90:100.0);//这里实际上返回了90.0,所以尽量保证三元操作符中的两个操作数类型一致
		System.out.println(s.equals(s1));
	}

}
