package com.xyq.team.domain;

import com.xyq.team.service.Status;

public class Programmer extends Employee {
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Programmer(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment) {
		super(id, name, age, salary);
		this.memberId = memberId;
		this.status = status;
		this.equipment = equipment;
	}
	public Programmer(int id, String name, int age, double salary) {
		super(id, name, age, salary);
	}
	public Programmer() {
		
	}
	@Override
	public String toString() {
		return "Programmer [id="+getId()+",name="+getName()+", age="+getAge()+
				", salary="+getSalary()+ ", equipment=" + equipment+"]";
	}
	
}
