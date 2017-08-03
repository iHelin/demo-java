package me.ianhe.test;

public class Main {

	public static void main(String[] args) {
		Object o = new Object() {
			public boolean equals(Object obj) {
				return true;
			}
		};
		System.out.println(o.equals("Fred"));
	}
}
