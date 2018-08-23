package com.xyq.demo1;

public class Piao extends Thread {
	
	private static int count = 10;
	
	public Piao(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			synchronized(Piao.class){
				if(count > 0) {
					System.out.println("我在第"+this.getName()+"买到了第"+(count--)+"张票");
				}
			}
		}
	}

}
