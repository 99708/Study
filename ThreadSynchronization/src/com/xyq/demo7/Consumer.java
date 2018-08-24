package com.xyq.demo7;

public class Consumer implements Runnable {

	Product p = new Product();
	
	public Consumer(Product p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			p.getProduct();
		}
	}

}
