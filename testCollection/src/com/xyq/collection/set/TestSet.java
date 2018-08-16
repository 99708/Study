package com.xyq.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class TestSet {
	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(6);
		set.add(45);
		set.add(68);
		set.add(6);
		set.add(90);
		
//		System.out.println(set);
//		System.out.println(set.size());
		
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("aaa");
		set2.add("bbb");
		set2.add("aaa");
		set2.add("dddd");
		
//		System.out.println(set2);
//		System.out.println(set2.size());
		
//		HashSet<Student3> set3 = new HashSet<Student3>();
		LinkedHashSet<Student3> set3 = new LinkedHashSet<Student3>();
		
		set3.add(new Student3("z3", 23));
		set3.add(new Student3("l4", 24));
		set3.add(new Student3("z3", 23));
		set3.add(new Student3("w5", 25));
		
		
		System.out.println(set3);
		System.out.println(set3.size());
	}

}

class Student3{
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Student3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student3 [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Student3 other = (Student3) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}







