package me.ianhe.test;

import me.ianhe.model.Apple;

public class TestApple {
	
	public static void main(String[] args) {
		Apple a = new Apple(1);
		Apple b = new Apple(1);
		System.out.println(a.equals(b));
	}

}
