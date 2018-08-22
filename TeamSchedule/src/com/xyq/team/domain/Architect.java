package com.xyq.team.domain;

public class Architect extends Employee {
	private int stock;
	private double bouns;
	private Equipment equipment;
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getBouns() {
		return bouns;
	}
	public void setBouns(double bouns) {
		this.bouns = bouns;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Architect(int id, String name, int age, double salary, int stock, double bouns, Equipment equipment) {
		super(id, name, age, salary);
		this.stock = stock;
		this.bouns = bouns;
		this.equipment = equipment;
	}
	public Architect(int id, String name, int age, double salary) {
		super(id, name, age, salary);
	}
	public Architect(int id, String name, int age, double salary, int stock, double bouns) {
		super(id, name, age, salary);
		this.stock = stock;
		this.bouns = bouns;
	}
	@Override
	public String toString() {
		return "Architect [id="+getId()+",name="+getName()+", age="+getAge()+", salary="
				+getSalary()+"stock=" + stock + ", bouns=" + bouns + ", equipment=" + 
				equipment+"]";
	}
	
	
}
