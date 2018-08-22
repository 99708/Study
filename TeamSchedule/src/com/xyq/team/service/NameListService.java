package com.xyq.team.service;

import com.xyq.team.domain.Architect;
import com.xyq.team.domain.Designer;
import com.xyq.team.domain.Employee;
import com.xyq.team.domain.Equipment;
import com.xyq.team.domain.NoteBook;
import com.xyq.team.domain.PC;
import com.xyq.team.domain.Printer;
import com.xyq.team.domain.Programmer;

public class NameListService {
	
	private Employee[] employees;

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public NameListService() {
		this.employees = new Employee[Data.EMPLOYEES.length];
		for(int i=0; i<employees.length; i++) {
			
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]); 
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			int stock = 0; 
			double bouns = 0.0;
			
			if(type == Data.EMPLOYEE) {
				Employee emp = new Employee(id, name, age, salary);
				employees[i] = emp;
			}
			if(type == Data.PROGRAMMER) {
				Programmer pro = new Programmer(id, name, age, salary);
				pro.setEquipment(createEquipment(i));
				employees[i] = pro;
			}
			if(type == Data.DESIGNER) {
				bouns = Double.parseDouble(Data.EMPLOYEES[i][5]);
				Designer des = new Designer(id, name, age, salary, bouns);
				des.setEquipment(createEquipment(i));		
				employees[i] = des;
			}
			if(type == Data.ARCHITECT) {
				bouns = Double.parseDouble(Data.EMPLOYEES[i][5]);
				stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				Architect arc = new Architect(id, name, age, salary, stock, bouns);
				arc.setEquipment(createEquipment(i));
				employees[i] = arc;
			}
		}
		
	}
	
	public Equipment createEquipment(int i) {
		
			int type = Integer.parseInt(Data.EQIPMENTS[i][0]);
			if(type == Data.PC) {
				PC pc = new PC(Data.EQIPMENTS[i][1], Data.EQIPMENTS[i][2]);
				return pc;
			}
			if(type == Data.NOTEBOOK) {
				NoteBook noteBook = new NoteBook(
						Data.EQIPMENTS[i][1], 
						Double.parseDouble(Data.EQIPMENTS[i][2]));
				return noteBook;
			}
			if(type == Data.PRINTER) {
				Printer printer = new Printer(Data.EQIPMENTS[i][1], Data.EQIPMENTS[i][2]);
				return printer;
			}
		
		return null;
	}
	
	public void printEmployeeMessage() {
		
	}
	
	public Employee[] getAllEmployees() {
		return this.employees;
	}
	
	public Employee getEmployee(int id) {
		for(int i=0; i<employees.length; i++) {
			if(id == employees[i].getId()) {
				return employees[i];
			}
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		
//		
//	}

}
