package com.xyq.demo7;

public class Producer implements Runnable {

	Product p = new Product();
	
	public Producer(Product p) {
		this.p = p;
	}
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
				
			if(i % 2 == 0) {
				p.setProduct("哈尔滨", "啤酒");
			}else {
				p.setProduct("德芙", "巧克力");
			}
				
		}
	}

}
