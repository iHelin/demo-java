package me.ianhe.test;

public class Test3 {
	
	private Test3(){
		throw new AssertionError();
	}

	public static void main(String[] args) {
		throw new IllegalArgumentException("哈哈");
		//System.out.println("你好");
	}
}
