package com.xyq.demo2;

public class Piao2 implements Runnable {
	
	private int count = 10;

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			synchronized(this) {
				if(count > 0) {
					System.out.println("我在"+Thread.currentThread().getName()+"买到了第"+(count--)+"张票");
				}
			}
		}
	}

}
