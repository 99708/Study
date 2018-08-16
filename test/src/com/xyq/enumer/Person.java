package com.xyq.enumer;

public class Person {
	
	private Sex sex;

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Person(Sex sex) {
		this.sex = sex;
	}

	public Person() {
	}

	@Override
	public String toString() {
		return "Person [sex=" + sex + "]";
	}
	
	
}
