package com.xyq.test03;

public class Demo3 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			
			if(i == 5) {
				TestThread tt = new TestThread();
				Thread t = new Thread(tt);
				t.setDaemon(true);
				t.start();
			}
			System.out.println(Thread.currentThread().getName());
			
		}
	}
}

class TestThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println(Thread.currentThread().getName()+"----"+i);
		}
		
	}}