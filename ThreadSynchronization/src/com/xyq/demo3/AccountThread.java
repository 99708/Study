package com.xyq.demo3;

public class AccountThread implements Runnable {
			
	private Account ac;
	
	public AccountThread(Account ac) {
		this.ac = ac;
	}
			
	@Override
	public void run() {
			
		synchronized(this) {
			
			if(ac.selectMonery() > 300) {
			
				System.out.println(Thread.currentThread().getName()+"来取钱，取走了400元");
				ac.quMonery(400);
			}else {
			
				System.out.println(Thread.currentThread().getName()+"来取钱，取钱失败");
			}
		}
	}

}
