package com.xyq.thread;

public class Test1 {
	public static void main(String[] args) {
		TestThreadName ttn = new TestThreadName("子线程");
		ttn.start();
		
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
