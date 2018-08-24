package com.xyq.demo6;

public class Product {
	
	private String brand;
	private String name;
	
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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setBrand(brand);
		this.setName(name);
		System.out.println("生产者生产了" + this.getBrand() + "------" + this.getName());
	}
	
	public synchronized void getProduct() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者消费了" + this.getBrand() + "---" + this.getName());
		
	}
	
	
	
}
