package com.xyq.demo7;

public class Product {
	
	private String brand;
	private String name;
	private boolean flag = true;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public synchronized void setProduct(String brand, String name) {
		//等待
		if(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setBrand(brand);
		this.setName(name);
		System.out.println("生产者生产了" + this.getBrand() + "------" + this.getName());
		//通知消费者
		notify();
		flag = false;
	}
	
	public synchronized void getProduct() {
		//等待
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//消费
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者消费了" + this.getBrand() + "---" + this.getName());
		//通知
		notify();
		flag = true;
		
	}
	
	
	
}
