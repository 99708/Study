package com.xyq.test;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("hello world");
		Student student = new Student("z3", 23, 55, 66);
		System.out.println(student);
	}
}

class Student{
	
	private String name;
	int age;
	protected double height;
	public double weight;
	
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	public Student(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	public Student() {
	}
	
	
	
	
	
}