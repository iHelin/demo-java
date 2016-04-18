package com.ihelin.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) throws ParseException {
		String str = "regre105 dfewfewgverb";
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(str);   
		System.out.println( m.replaceAll("").trim());
		
	}

}
