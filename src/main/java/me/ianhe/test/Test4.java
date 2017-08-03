package me.ianhe.test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Test4 {

	// private Date birthDate;

	private static final Date BOOM_START;
	private static final Date BOOM_END;

	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}

	public boolean isBabyBoomer(Date birthDate) {
		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}

	public static void main(String[] args) {
		Test4 test = new Test4();
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1947, Calendar.JANUARY, 1, 0, 0, 0);
		System.out.println(test.isBabyBoomer(gmtCal.getTime()));
	}

}
