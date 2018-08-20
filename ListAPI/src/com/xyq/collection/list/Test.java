package com.xyq.collection.list;

public class Test {
	public static void main(String[] args) {
		
		MyArrayList mal = new MyArrayList();
		
		Student stu1 = new Student("z3", 23);
		Student stu2 = new Student("L4", 24);
		Student stu3 = new Student("W5", 25);
		Student stu4 = new Student("z6", 26);
		Student stu5 = new Student("m7", 27);
		
		mal.add(stu1);
		mal.add(stu2);
		mal.add(stu3);
		mal.add(stu4);
		mal.add(stu5);
		
		
		for(int i=0; i<mal.count; i++) {
			System.out.println(mal.get(i));
		}
		
		System.out.println("=================");
		System.out.println(mal);
		
	}
}
