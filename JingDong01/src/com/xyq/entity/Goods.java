package com.xyq.entity;

public class Goods {
	
	private int id;
	private String name;
	private float price;
	private String color;
	private float size;
	private int stock;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public String getColor() {
		return color;
	}
	public float getSize() {
		return size;
	}
	public int getStock() {
		return stock;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Goods(int id, String name, float price, String color, float size, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
		this.size = size;
		this.stock = stock;
	}
	
	public Goods() {
	}
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + price + "\t" + color + "\t" + size
				+ "\t" + stock;
	}
	
}
