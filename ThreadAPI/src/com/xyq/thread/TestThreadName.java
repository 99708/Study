package com.xyq.thread;

public class TestThreadName extends Thread {
	
	public TestThreadName(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(super.getName());
		}
	}

}
