package me.ianhe.reflect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static final String ID = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$";
	public static final String EMAIL = "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
	public static final String URL = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
	public static final String USERNAME = "^[A-Za-z][A-Za-z1-9_-]+$";// （字母开头 + 数字/字母/下划线）
	public static final String TEL = "^1[3|4|5|8][0-9]\\d{8}$";
	public static final String QQ = "^[1-9]\\d{4,10}$";
	public static final String ZipCode = "^[1-9]\\d{5}$";
	
	public static void main(String[] args) {
		// 按指定模式在字符串查找
		String line = "18655591038";

		

		Pattern r = Pattern.compile(URL);
		Matcher m = r.matcher(line);
		System.out.println(m.matches());
	}

}
