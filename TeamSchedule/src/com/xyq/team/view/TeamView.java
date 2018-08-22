package com.xyq.team.view;

import com.xyq.team.domain.Employee;
import com.xyq.team.service.NameListService;
import com.xyq.team.service.TeamService;

public class TeamView {
	
	NameListService listSvc = new NameListService();
	TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		System.out.println("-----------------------------开发团队调度软件------------------------------");
		System.out.print("\nID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备\n");
		
		NameListService nls = new NameListService();
		Employee[] allEmployees = nls.getAllEmployees();
		for(int i=0; i<allEmployees.length; i++) {
			if(i < 5) {
				System.out.println(allEmployees[i].getId()+"\t"
									+allEmployees[i].getName()+"\t"
									+allEmployees[i].getAge()+"\t"
									+allEmployees[i].getSalary()+"\t");
			}
		}
		
		System.out.println("\n-----------------------------------------------------------------------");
		System.out.print("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择（1-4）：");
	}
	public void listAllEmployees() {
		
	}
	public void addMember () {}
	public void deleteMember () {}
	public static void main(String[] args) {
		TeamView teamView = new TeamView();
		teamView.enterMainMenu();
		
	}
	
	
	

}
