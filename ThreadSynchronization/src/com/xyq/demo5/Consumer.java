package com.xyq.demo5;

public class Consumer implements Runnable {

	Product p = new Product();
	
	public Consumer(Product p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			synchronized(p) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("消费者消费了" + p.getBrand() + "---" + p.getName());
			}
		}
	}

}
