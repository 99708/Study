package com.xyq.thread;

public class Demo1 {
	public static void main(String[] args) {
//		Thread.currentThread().setName("主线程");
		Test test = new Test();
//		test.setName("test---");
		test.start();
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}

class Test extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}