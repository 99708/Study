package com.xyq.test02;

public class Test02 {
	public static void main(String[] args) {
		Piao2 p = new Piao2();
		Thread t1 = new Thread(p, "窗口1");
		t1.start();
		Thread t2 = new Thread(p, "窗口2");
		t2.start();
		Thread t3 = new Thread(p, "窗口3");
		t3.start();
	}

}
