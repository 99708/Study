package com.xyq.test06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test3 {
	public static void main(String[] args) {
		Test3 test3 = new Test3();
		test3.listToMap();
		test3.mapToList();
		
	}
	
	public void listToMap() {
		
		ArrayList<Student> lists = new ArrayList<Student>();
		
		lists.add(new Student(1, "乔峰", 40, "男"));
		lists.add(new Student(2, "珠儿", 30, "女"));
		lists.add(new Student(3, "段誉", 40, "男"));
		lists.add(new Student(4, "王语嫣", 30, "女"));
		lists.add(new Student(5, "扫地僧", 40, "男"));
		
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		
		Iterator<Student> it = lists.iterator();
		while(it.hasNext()) {
			Student stu = it.next();
			map.put(stu.getId(), stu);
			System.out.println(stu);
		}
		
		Set<Entry<Integer, Student>> entrys = map.entrySet();
		for(Entry<Integer, Student> en:entrys) {
			System.out.println(en.getKey() + "," + en.getValue());
		}
		
	}
	
	public void mapToList(){ 
		
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		
		map.put(1, new Student(1, "乔峰", 40, "男"));
		map.put(2, new Student(2, "珠儿", 30, "女"));
		map.put(3, new Student(3, "段誉", 40, "男"));
		map.put(4, new Student(4, "王语嫣", 30, "女"));
		map.put(5, new Student(5, "扫地僧", 40, "男"));
		
		Set<Entry<Integer, Student>> entrys = map.entrySet();
		StudentEntry studentEntry = new StudentEntry();
		studentEntry.setEntrys(entrys);
		
		ArrayList<StudentEntry> lists = new ArrayList<StudentEntry>();
		lists.add(studentEntry);
		
		Iterator<StudentEntry> it = lists.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class Student{
	
	private int id;
	private String name;
	private int age;
	private String sex;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Student(int id, String name, int age, String sex) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public Student() {
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}

class StudentEntry {
	
		private Set<Entry<Integer, Student>> entrys;

		public Set<Entry<Integer, Student>> getEntrys() {
			return entrys;
		}

		public void setEntrys(Set<Entry<Integer, Student>> entrys) {
			this.entrys = entrys;
		}

		@Override
		public String toString() {
			if(entrys != null) {
				for(Entry<Integer, Student> en:entrys) {
					System.out.println(en.getKey() + "," + en.getValue());
				}
			}
			return "";
		}	
		
		
		
}