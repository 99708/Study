package com.xyq.team.view;

import com.xyq.team.domain.Employee;
import com.xyq.team.service.NameListService;
import com.xyq.team.service.TeamService;
import com.xyq.team.util.TSUtility;

public class TeamView {
	
	NameListService listSvc = new NameListService();
	TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		while(true) {
			System.out.println("---------------------------------开发团队调度软件--------------------------------");
			System.out.print("\nID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备\n");
			
			Employee[] allEmployees = listSvc.getAllEmployees();
			for(int i=0; i<allEmployees.length; i++) {
//				if(i < 5) {
//					listSvc.printEmployeeMessages(i);
//				}
				listSvc.printEmployeeMessages(i);
			}
			
			System.out.println("\n-----------------------------------------------------------------------------");
			System.out.print("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择（1-4）：");
			char selection = TSUtility.readMenuSelection();
			
			switch(selection) {
			case '1':
				listAllEmployees();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("\n谢谢使用！");
				return;
			}
		}
		
	}
	public void listAllEmployees() {
		System.out.println("---------------------------------团队成员列表--------------------------------");
		System.out.print("\nTID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
		
		Employee[] allEmployees = listSvc.getAllEmployees();
		for(int i=0; i<allEmployees.length; i++) {
			if(i < 5) {
				listSvc.printEmployeeMessage(i);
			}
		}
		
		System.out.println("\n-----------------------------------------------------------------------------");
		System.out.print("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择（1-4）：");
	}
	public void addMember () {
		System.out.println("---------------------------------------添加成员----------------------------------\n");
		System.out.println("请输入员工的ID：");
		int id = TSUtility.readInt();
		Employee e = null;
		if((e = listSvc.getEmployee(id)) != null) {
			teamSvc.addMember(e);
			System.out.println("添加成功！");
			TSUtility.readReturn();
		}
		
	}
	public void deleteMember () {
		System.out.println("3");
	}
	
	public static void main(String[] args) {
		TeamView teamView = new TeamView();
		teamView.enterMainMenu();
		
	}
	
	
	

}
