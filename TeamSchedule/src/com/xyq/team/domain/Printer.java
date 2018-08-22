package com.xyq.team.domain;

public class Printer implements Equipment{

	private String name;
	private String type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Printer(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public Printer() {
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return type + "(" + name + ")";
	}
	
	

}
