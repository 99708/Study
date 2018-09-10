package com.xyq.test;

import java.util.Scanner;

import com.xyq.service.impl.EmpServiceImpl;
import com.xyq.util.DBUtil;

public class TestEmp {
	
	public static void main(String[] args) {
		
		EmpServiceImpl es = new EmpServiceImpl();
		
		while(true) {
			System.out.println("**************欢迎来到员工管理系统**************");
			System.out.println("\t1.添加员工\n\t2.查询所有员工信息\n\t3.查询员工信息\n\t4.更新员工信息\n\t5.删除员工信息\n\t6.退出系统");
			System.out.println("*******************************************");
			System.out.println("请选择：");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					es.addEmp();
					break;
				case 2:
					DBUtil.getConnection();
					es.findEmp();
					break;
				case 3:
					es.findEmpByEmpno();
					break;
				case 4:
					es.upEmpByEmpno();
					break;
				case 5:
					es.deleteEmpByEmpno();
					break;
				case 6:
					System.out.println("谢谢使用");
					return;

			}
		}
	}
}
