package com.xyq.team.view;

import com.xyq.team.domain.Employee;
import com.xyq.team.service.NameListService;
import com.xyq.team.service.TeamException;
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
				listSvc.printEmployeeMessage(i);
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
		
		if(teamSvc.getTeam() != null) {
			System.out.println("---------------------------------团队成员列表--------------------------------");
			System.out.print("\nTID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
			
			teamSvc.printTeamMessage();
		
			System.out.println("\n-----------------------------------------------------------------------------");
			System.out.println("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择（1-4）：");
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
		}else {
			System.out.println("团队还没有成员，请先添加成员");
			TSUtility.readReturn();
		}
		
	}
	public void addMember () {
		System.out.println("---------------------------------------添加成员----------------------------------\n");
		System.out.println("请输入员工的ID：");
		int id = TSUtility.readInt();
		Employee e;
		try {
			e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("添加成功！");
		}  catch (TeamException e1) {
			System.out.println(e1.getMessage());
		}
		TSUtility.readReturn();
		
	}
	public void deleteMember () {
		if(teamSvc.getTeam() != null) {
			System.out.println("---------------------------------------删除成员----------------------------------\n");
			System.out.println("请输入要删除的员工的TID：");
			int tid = TSUtility.readInt();
			System.out.println("确认是否删除（Y/N）:");
			char c = TSUtility.readConfirmSelection();
			if(c == 'Y') {
				try {
					teamSvc.removeMember(tid);
				} catch (TeamException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("删除成功");
			}else {
				System.out.println("你以取消删除");
			}
		}else {
			System.out.println("团队中还没有成员，请先添加成员");
		}
		
		TSUtility.readReturn();
	}
	
	public static void main(String[] args) {
		TeamView teamView = new TeamView();
		teamView.enterMainMenu();
		
	}
	
	
	

}
