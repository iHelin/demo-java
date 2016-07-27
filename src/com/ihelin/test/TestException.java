package com.ihelin.test;

public class TestException {
	private static void bar() throws BlogAppException {
		System.out.println("let's assume BlogAppException happened when executing `create` command");
		// 为了演示，这里我们假设执行create命令时，抛出了异常
		throw new BlogAppException("create");
	}

	private static void foo() throws ArithmeticException {
		int x = 5 / 0;
		System.out.println(x);
	}

	public static void main(String[] args) {
		try {
			foo();
			bar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("program is still running here!");
	}
}
