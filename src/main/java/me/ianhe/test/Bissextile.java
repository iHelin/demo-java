package me.ianhe.test;

import java.util.Scanner;

public class Bissextile {
	public static void main(String[] arge) {
		System.out.print("请输入年份:");
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		scanner.close();
		if (year < 0 || year > 3000) {
			System.out.println("年份有误，程序退出！");
			System.exit(0);
		}
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			System.out.println(year + " is bissextile(闰年)!");
		else
			System.out.println(year + " is not bissextile(闰年)!");
	}

}
