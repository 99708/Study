package com.xyq.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(12);
		set.add(22);
		set.add(32);
		set.add(12);
		set.add(02);
		
		System.out.println(set);
		System.out.println(set.size());
		
		TreeSet<String> set2 = new TreeSet<String>();
		set2.add("hello");
		set2.add("world");
		set2.add("!");
		set2.add("nihoa");
		set2.add("hello");
		set2.add("world");
		
		
		System.out.println(set2);
		System.out.println(set2.size());
		
		TreeSet<Student> set3 = new TreeSet<Student>(new BiJiao1());
		
		set3.add(new Student("z3", 23));
		set3.add(new Student("l4", 24));
		set3.add(new Student("w5", 29));
		set3.add(new Student("z3", 28));
		set3.add(new Student("z6", 23));
		
		System.out.println(set3);
		System.out.println(set3.size());
	}
	
}

class Student /*implements Comparable<Student>*/{
	
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
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Student() {}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
//	@Override
//	public int compareTo(Student o) {
//		//按照年龄比较
//		return this.getAge()-o.getAge();
//		return this.getName().compareTo(o.getName());
//	}
	
}

class BiJiao1 implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		//按照年龄比较
//		return o1.getAge()-o2.getAge();
		//按照姓名比较
		return o1.getName().compareTo(o2.getName());
	}}
