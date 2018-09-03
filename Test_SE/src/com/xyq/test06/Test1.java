package com.xyq.test06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Test1 {
	public static void main(String[] args) {
		
		ArrayList<Book1> lists = new ArrayList<Book1>();
		lists.add(new Book1(1, "西游记", 23, "人民文学出版社"));
		lists.add(new Book1(2, "三国演义", 44, "人民文学出版社"));
		lists.add(new Book1(3, "水浒传", 23, "人民文学出版社"));
		lists.add(new Book1(4, "红楼梦", 59.70f, "人民文学出版社"));
		
		Iterator<Book1> it = lists.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		HashMap<Integer, Book1> map = new HashMap<Integer, Book1>();
		
		map.put(1, new Book1(1, "西游记", 23, "人民文学出版社"));
		map.put(2, new Book1(2, "三国演义", 44, "人民文学出版社"));
		map.put(3, new Book1(3, "水浒传", 23, "人民文学出版社"));
		map.put(4, new Book1(4, "红楼梦", 59.70f, "人民文学出版社"));
	
		Collection<Book1> values = map.values();
		for(Book1 value : values) {
			System.out.println(value);
		}
	
	}
}

class Book1{
	
	private int id;
	private String name;
	private float price;
	private String publish;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	public Book1(int id, String name, float price, String publish) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.publish = publish;
	}
	
	public Book1() {
	}
	
	@Override
	public String toString() {
		return "Book1 [id=" + id + ", name=" + name + ", price=" + price + ", publish=" + publish + "]";
	}
	
}
