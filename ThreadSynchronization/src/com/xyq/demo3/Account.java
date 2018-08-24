package com.xyq.demo3;

public class Account {
	private int monery = 600;
	
	public void quMonery(int num) {
		monery -= num;
	}
	
	public int selectMonery() {
		return monery;
	}
}
