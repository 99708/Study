package com.xyq.entity;

public class Mobile {
	
	private int id;
	private String brand;
	private String model;
	private int price;
	private int count;
	private String version;
	
	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public int getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}
	public String getVersion() {
		return version;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Mobile(int id, String brand, String model, int price, int count, String version) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.count = count;
		this.version = version;
	}
	
	public Mobile(String brand, String model, int price, int count, String version) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.count = count;
		this.version = version;
	}
	
	public Mobile() {}
	
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + ", count=" + count
				+ ", version=" + version + "]";
	}
	
}
