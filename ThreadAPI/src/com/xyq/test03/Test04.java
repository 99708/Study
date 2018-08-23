package com.xyq.test03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) throws InterruptedException {
		
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		
		while(true) {
		
			Date d = new Date();
			Thread.sleep(1000);
			System.out.println(df.format(d));
		}
		
	}

}
