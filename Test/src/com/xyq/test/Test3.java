package com.xyq.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年龄，分数和入学时间 （以空格隔开）");
		String age = sc.next();
		String score = sc.next();
		String time= sc.next();
		
		int age1 = Integer.parseInt(age);
		float score1 = Float.parseFloat(score);
		Date parse = null;
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 parse= date.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("age=" + age1 + ", " + "score=" + score1 + ", " + "time=" + parse);
	}

}
