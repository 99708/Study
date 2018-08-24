package com.xyq.demo4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Piao2 implements Runnable {
	
	private int count = 10;
	Lock lock = new ReentrantLock();

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			lock.lock();
			try {
				if(count > 0) {
					Thread.sleep(500);
					System.out.println("我在"+Thread.currentThread().getName()+"买到了第"+(count--)+"张票");
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				lock.unlock();
			}
		}
	}

}
