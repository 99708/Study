package com.xyq.demo3;

public class Test {
	public static void main(String[] args) {
		AccountThread at = new AccountThread(new Account());
		Thread t1 = new Thread(at, "A");
		t1.start();
		Thread t2 = new Thread(at, "B");
		t2.start();
	}

}
