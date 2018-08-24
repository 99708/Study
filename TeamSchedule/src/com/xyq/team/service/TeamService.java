package com.xyq.team.service;

import com.xyq.team.domain.Architect;
import com.xyq.team.domain.Designer;
import com.xyq.team.domain.Employee;
import com.xyq.team.domain.Programmer;

public class TeamService {
	static int counter = 1;
	final int MAX_MEMBER = 6;
	Programmer[] team = new Programmer[MAX_MEMBER];
	int total = 0;
	
	public Programmer[] getTeam() {
		if(total == 0) {
			return null;
		}
		return team;
	}
	
	public void addMember(Employee e) throws TeamException {
		int pNumber=0, dNumber=0, aNumber=0;
		
		for(int i=0; i<total; i++) {
			if(team[i].getId() == e.getId()) {
				throw new TeamException("该员工已是团队成员");
			}
		}
		if(total >= MAX_MEMBER) {
			throw new TeamException("团队已满，无法添加");
		}
		if(!(e instanceof Programmer)) {
			throw new TeamException("该员工不是开发人员，无法添加");
		}
		
		Programmer p = (Programmer) e;
		
		switch (p.getStatus()) {
		case BUSY:
			throw new TeamException("该员工已是团队成员");
		case VOCATION:
			throw new TeamException("该员工正在休假无法添加");
		}
		
		for(int i=0; i<total; i++) {
			if(team[i] instanceof Architect) {
				aNumber++;
			}else if(team[i] instanceof Designer) {
				dNumber++;
			}else if(team[i] instanceof Programmer) {
				pNumber++;
			}
		}
		if(p instanceof Architect) {
			if(aNumber >= 1) {
				throw new TeamException("团队中只能有一名架构师");
			}
		}else if(p instanceof Designer) {
			if(dNumber >= 2) {
				throw new TeamException("团队中只能有两名设计师");
			}
		}else if(p instanceof Programmer && pNumber >= 3) {
			throw new TeamException("团队中只能有三名程序员");
		}
		p.setMemberId(counter++);
		p.setStatus(Status.BUSY);
		team[total++] = p;
	}
	
	public void removeMember(int memberId) throws TeamException {
		for(int i=0; i<total; i++) {
			if(team[i].getMemberId() == memberId) {
				team[i] = team[i+1]; 
			}
			if(i == total) {
				throw new TeamException("要删除的员工不存在，请检查你的输入");
			}
		}
		team[total] = null;
		total--;
	}
	
	
	public void printTeamMessage() {
		for(int i=0; i<total; i++) {
			int tid = team[i].getMemberId();
			int id = team[i].getId();
			String name = team[i].getName();
			int age = team[i].getAge();
			double salary = team[i].getSalary();
			
			if(team[i] instanceof Architect) {
				Architect a = (Architect) team[i];
				System.out.println(tid+"/"+id+"\t"+name+"\t"+age+"\t"+salary+"\t"+"架构师\t"+a.getBouns()+"\t"+a.getStock());
			}else if(team[i] instanceof Designer) {
				Designer d = (Designer)team[i];
				System.out.println(tid+"/"+id+"\t"+name+"\t"+age+"\t"+salary+"\t"+"设计师\t"+d.getBouns());
			}else if(team[i] instanceof Programmer) {
				System.out.println(tid+"/"+id+"\t"+name+"\t"+age+"\t"+salary+"\t"+"程序员\t");
			}
		}
	
	}


}
