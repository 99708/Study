package com.xyq.test03;

public class Demo2 {
	public static void main(String[] args) {
		for (int i  = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"--"+i);
			if(i == 5) {
				Thread.currentThread().stop();
			}
		}
	}
}
