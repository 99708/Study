package com.xyq.date;

import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		
		Date d1 = new Date();
		
		System.out.println(d1.getDate());//此日期所表示的月份中的某一天。
		System.out.println(d1.getTime());//毫秒为单位
		System.out.println(System.currentTimeMillis());
		System.out.println(d1.getYear());//与1900的差值
		System.out.println(d1.getMonth());//第几月
		System.out.println(d1.getDay());//周几
		
		/**
		 * Date 与 sqlDate的区别和联系
		 * 区别：Date精确到年月日时分秒 sqlDate 精确到年月日
		 * 联系：public class Date extends java.util.Date
		 */
		
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		System.out.println(d2);
		System.out.println(d1.toLocaleString());
		
		Date d3 = d2;
		java.sql.Date d4 = new java.sql.Date(new Date().getTime());
		System.out.println(d4);
		
	}
	
}
