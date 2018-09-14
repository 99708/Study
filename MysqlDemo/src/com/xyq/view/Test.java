package com.xyq.view;

import com.xyq.service.StudentService;
import com.xyq.service.impl.StudentServiceImpl;
import com.xyq.util.TSUtility;

public class Test {
	
	StudentService ss = new StudentServiceImpl();
	
	public static void main(String[] args) {
		Test t = new Test();
		t.enterMenu();
	}
	
	public void enterMenu() {
		while(true) {
			System.out.println("***************欢迎来到学生管理系统******************");
			System.out.println("\t1.查询所有学生及其课程信息\n\t2.添加学生信息\n\t3.修改学生信息\n\t4.删除学生信息\n\t5.退出");
			System.out.println("************************************************");
			System.out.print("请输入你的选择：");
			int choice = TSUtility.readInt();
			switch(choice) {
				case 1:
					ss.listStudent();
					break;
				case 2:
					ss.add();
					break;
				case 3:
					ss.update();
					break;
				case 4:
					ss.delete();
					break;
				case 5:
					System.out.println("谢谢使用本系统");
					return;
			
			}
		}
		
	}
}
