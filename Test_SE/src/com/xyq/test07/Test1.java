package com.xyq.test07;

public class Test1 implements Runnable {
	
	private int ticketNum = 100;
	
	public static void main(String[] args) {
		
		Test1 t = new Test1();
		
		Thread tt1 = new Thread(t, "窗口1");
		Thread tt2 = new Thread(t, "窗口2");
		Thread tt3 = new Thread(t, "窗口3");
		Thread tt4 = new Thread(t, "窗口4");
		Thread tt5 = new Thread(t, "窗口5");
		
		tt1.start();
		tt2.start();
		tt3.start();
		tt4.start();
		tt5.start();
	}

	@Override
	public void run() {
		while(ticketNum > 0) {
			buy();
		}
	}
	
	
	public synchronized void buy() {
		if(ticketNum > 0) {
			System.out.println(Thread.currentThread().getName() + ":" + ticketNum--);
		}
	}
}
