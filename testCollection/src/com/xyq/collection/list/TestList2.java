package com.xyq.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

public class TestList2 {
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		
		Student1 stu = new Student1("lili", 23, Gender.女);
		Student1 stu2 = new Student1("nana", 24, Gender.男);
		Student1 stu3 = new Student1("nunu", 14, Gender.女);
		Student1 stu4 = new Student1("mingming", 18, Gender.男);
		
		al.add(stu);
		al.add(stu2);
		al.add(stu3);
		al.add(stu4);
		
		Iterator it = al.iterator();
		while(it.hasNext()) {
			Student1 s = (Student1)it.next();
			System.out.println(s.getName() + "====" + s.getAge());
		}
		
	}
}

class Student1{
	
	private String name;
	private int age;
	private Gender sex;
	
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
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public Student1(String name, int age, Gender sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public Student1() {
	}
	
}

enum Gender{
	男,女;
}