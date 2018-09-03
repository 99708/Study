package com.xyq.test06;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Test2 {
		
	public static void main(String[] args) {
		
		HashSet<Book2> sets = new HashSet<Book2>();
		
		sets.add(new Book2(1, "西游记", 23, "人民文学出版社"));
		sets.add(new Book2(1, "西游记", 23, "人民文学出版社"));
		sets.add(new Book2(2, "三国演义", 44, "人民文学出版社"));
		sets.add(new Book2(3, "水浒传", 23, "人民文学出版社"));
		sets.add(new Book2(3, "水浒传", 23, "人民文学出版社"));
		sets.add(new Book2(4, "红楼梦", 59.70f, "人民文学出版社"));
	
		Iterator<Book2> it = sets.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		TreeSet<Book2> treeSet = new TreeSet<Book2>(new BiJiao());
		
		treeSet.add(new Book2(1, "西游记", 23, "人民文学出版社"));
		treeSet.add(new Book2(1, "西游记", 23, "人民文学出版社"));
		treeSet.add(new Book2(2, "三国演义", 44, "人民文学出版社"));
		treeSet.add(new Book2(3, "水浒传", 23, "人民文学出版社"));
		treeSet.add(new Book2(3, "水浒传", 23, "人民文学出版社"));
		treeSet.add(new Book2(4, "红楼梦", 59.70f, "人民文学出版社"));
		
		Iterator<Book2> it2 = treeSet.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
	}
	
}

class Book2{
	
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
	
	public Book2(int id, String name, float price, String publish) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.publish = publish;
	}
	
	public Book2() {
	}
	
	@Override
	public String toString() {
		return "Book2 [id=" + id + ", name=" + name + ", price=" + price + ", publish=" + publish + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((publish == null) ? 0 : publish.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book2 other = (Book2) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (publish == null) {
			if (other.publish != null)
				return false;
		} else if (!publish.equals(other.publish))
			return false;
		return true;
	}


}

class BiJiao implements Comparator<Book2>{

	@Override
	public int compare(Book2 o1, Book2 o2) {
		return o1.getId() - o2.getId();
	}
	
}
