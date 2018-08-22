package com.xyq.team.domain;

public class Designer extends Programmer{
	private double bouns;
	private Equipment equipment;
	
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
	public Designer(int id, String name, int age, double salary, double bouns, Equipment equipment) {
		super(id, name, age, salary);
		this.bouns = bouns;
		this.equipment = equipment;
	}
	public Designer(int id, String name, int age, double salary) {
		super(id, name, age, salary);
	}
	public Designer(int id, String name, int age, double salary, double bouns) {
		super(id, name, age, salary);
		this.bouns = bouns;
	}
	
	@Override
	public String toString() {
		return "Architect [id="+getId()+",name="+getName()+", age="+getAge()+", salary="
				+getSalary()+ ", bouns=" + bouns + ", equipment=" + equipment+"]";
	}
	
	
	
	
	

}
