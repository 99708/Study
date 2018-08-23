package com.xyq.test02;

public class Piao extends Thread {
	
	private static int count = 10;
	
	public Piao(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			if(count > 0) {
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				System.out.println("我在第"+this.getName()+"买到了第"+(count--)+"张票");
			}
		}
	}
	

}
