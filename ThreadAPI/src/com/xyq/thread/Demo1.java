package com.xyq.thread;

public class Demo1 {
	public static void main(String[] args) {
		Test test = new Test();
		test.start();
		for(int i=0; i<10; i++) {
			System.out.println("main--" + i);
		}
	}

}

class Test extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Thread---" + i);
		}
	}
}