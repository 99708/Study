package com.xyq.date;

import java.util.Calendar;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(5));
		
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		System.out.println(cal);
	}
}
