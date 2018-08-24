package com.xyq.demo5;

public class Producer implements Runnable {

	Product p = new Product();
	
	public Producer(Product p) {
		this.p = p;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			synchronized(p) {
				
				if(i % 2 == 0) {
					p.setBrand("哈尔滨");
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					p.setName("啤酒");
				}else {
					p.setBrand("德芙");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					p.setName("巧克力");
				}
				
				System.out.println("生产者生产了" + p.getBrand() + "------" + p.getName());
			}
		}
	}

}
