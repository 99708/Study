package com.xyq.demo5;

public class Test {
	public static void main(String[] args) {
		
		Product p = new Product();
	
		Producer pro = new Producer(p);
		Thread t1 = new Thread(pro);
		t1.start();
	
		Consumer con = new Consumer(p);
		Thread t2 = new Thread(con);
		t2.start();
	}
}