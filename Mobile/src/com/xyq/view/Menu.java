package com.xyq.view;

import java.util.Iterator;
import java.util.List;

import com.xyq.entity.Mobile;
import com.xyq.service.MobileService;
import com.xyq.service.imp.MobileServiceImp;
import com.xyq.util.TSUtility;

public class Menu {
	
	MobileService mobileService = new MobileServiceImp();
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.enterMainMenu();
	}
	
	public void enterMainMenu() {
		while(true) {
			System.out.println("*************欢迎来到手机信息管理系统*****************");
			System.out.println("\t1.手机录入\n\t2.根据手机品牌查询手机信息\n\t3.查询全部手机信息\n\t4.根据手机编号修改手机价格\n\t5.根据手机编号删除手机记录\n\t6.退出");
			System.out.println("************************************************");
			System.out.println("请选择：");
			char choice = TSUtility.readMenuSelection();
			switch (choice) {
				case '1':
					mobileService.add();
					System.out.println("添加成功");
					break;
				case '2':
					Mobile mobile = mobileService.findByBrand();
					System.out.println(mobile);
					break;
				case '3':
					List<Mobile> list = mobileService.list();
					Iterator<Mobile> it = list.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
					break;
				case '4':
					int result = mobileService.updatePriceById();
					if(result != -1) {
						System.out.println("修改成功");
					}else {
						System.out.println("修改失败");
					}
					break;
				case '5':
					int res = mobileService.deleteById();
					if(res != -1) {
						System.out.println("删除成功");
					}else {
						System.out.println("删除失败");
					}
					break;
				case '6':
					System.out.println("谢谢使用本系统");
					return;
			}
		}
		
	}
}
