package com.xyq.view;

import com.xyq.Util.TSUtility;
import com.xyq.service.UserService;
import com.xyq.serviceImpl.UserServiceImpl;

public class Index {
	
	UserService us = new UserServiceImpl();
	
	public static void main(String[] args) {
		Index ind = new Index();
		ind.MenuMain();
	}
	
	public void MenuMain() {
		while(true){
			System.out.println("*************欢迎来到音乐上传网站************");
			System.out.println("\t\t1.登录\n\t\t2.上传音乐\n\t\t3.退出");
			System.out.println("****************************************");
			System.out.print("请选择你的操作：");
			char choice = TSUtility.readMenuSelection();
			switch(choice) {
				case '1':
					login();
					break;
				case '2':
					break;
				case '3':
					System.out.println("谢谢使用本系统");
					return;
			}
		}
		
	}
	
	public void login() {
		us.login();
	}
}
