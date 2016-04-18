package com.ihelin.www;

import java.lang.reflect.Constructor;
import java.util.Date;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException {
		Date d = new Date();
		
		Class c1 = d.getClass();
		System.out.println(c1.getSimpleName());
//		Constructor[] ct = c1.getDeclaredConstructors();
//		for (Constructor constructor : ct) {
//			System.out.println(constructor.getTypeParameters());
//		}
		
		
		String s = "java.util.Date";
		String[] ss = new String[12];
		Class c2 = ss.getClass();
		//System.out.println(Class.forName(s));
		//System.out.println(c2.isArray());
		
	}
}
