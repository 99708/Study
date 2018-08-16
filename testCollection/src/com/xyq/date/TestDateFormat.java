package com.xyq.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String[] args) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(df.parse("2018年8月14日  17:31:59"));
		
		Date date = new Date();
		System.out.println(df.format(date));
	}
}
