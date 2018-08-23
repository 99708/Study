package com.xyq.test03;

public class Test03 {
	public static void main(String[] args) throws InterruptedException {
		ThreadTest01 tt = new ThreadTest01();
		Thread t = new Thread(tt);
		t.start();
		for(int i=0; i<10; i++) {
			if(i == 6) {
				t.join();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
}	

class ThreadTest01 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}}