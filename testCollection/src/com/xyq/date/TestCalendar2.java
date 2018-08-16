package com.xyq.date;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class TestCalendar2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个日期如（2018-08-16）");
		String str = sc.next();
		
		Date date = Date.valueOf(str);
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		
		int nowDay = cl.get(Calendar.DATE);
		int maxDay = cl.getActualMaximum(Calendar.DATE);
		
		cl.set(Calendar.DATE, 1);
		int week = cl.get(Calendar.DAY_OF_WEEK);
		int count = 0;
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		
		for (int i=0; i<week-1; i++) {
			System.out.print("\t");
			count++;
		}
		for(int i=1; i<=maxDay; i++) {
			
			if(i == nowDay) {
				System.out.print(i + "*\t");
				count++;
			}else {
				System.out.print(i+"\t");
				count++;
			}
			
			if(count % 7 == 0) {
				System.out.println();
			}
		}
	}
}
