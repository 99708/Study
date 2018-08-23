package com.xyq.team.service;

import com.xyq.team.domain.Architect;
import com.xyq.team.domain.Designer;
import com.xyq.team.domain.Employee;
import com.xyq.team.domain.Programmer;

public class TeamService {
	static int counter;
	final int MAX_MEMBER = 6;
	Employee[] team = new Employee[MAX_MEMBER];
	int total = 0;
	
	public Programmer[] getTeam() {
		return null;
	}
	
	public void addMember(Employee e) {
		int pNumber=0, dNumber=0, aNumber=0;
		for(int i=0; i<total; i++) {
			if(team[i].getId() == e.getId()) {
				System.out.println("该员工已是团队成员");
				return;
			}
		}
		if(total < MAX_MEMBER) {
			if(e instanceof Programmer) {
				team[total++] = e;
				counter++;
			}else {
				System.out.println("该员工不是开发人员，无法添加");
			}
			
		}else {
			System.out.println("成员已满无法添加");
		}
		
		for(int i=0; i<total; i++) {
			if(team[i] instanceof Programmer) {
				pNumber++;
//				if(pNumber) {}
			}
			if(team[i] instanceof Designer) {
				dNumber++;
			}
			if(team[i] instanceof Architect) {
				aNumber++;
			}
		}
	}
	
	public void removeMember(int memberId) {
		
	}

}
