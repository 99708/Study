package com.xyq.matn;

import java.util.Random;

public class TestRandom {
	public static void main(String[] args) {
		Random rd = new Random();
		
		for (int i = 0; i < 10; i++) {
//			System.out.println(rd.nextInt(10));//[0,10)
			System.out.println(rd.nextDouble());//[0,1)
		}
		
		Math.random();//static final Random randomNumberGenerator = new Random();
	}
}
