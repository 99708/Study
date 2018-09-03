package com.xyq.view;

import com.xyq.util.TSUtility;

public class JDView {
	public static void main(String[] args) {
		JDView jdv = new JDView();
		jdv.enterMainMenu();
	}
	
	public void enterMainMenu() {
		while(true) {
			System.out.println("**************欢迎进入京东商城************");
			System.out.print("\t1.添加商品\n\t2.查看所有商品\n\t3.查看指定编号商品\n\t4.添加到购物车\n\t5.显示购物车\n\t6.退出\n");
			System.out.println("***************************************");
			System.out.print("请选择菜单：");
			char selection = TSUtility.readMenuSelection();
			
			switch(selection) {
			case '1':
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
			case '5':
				break;
			case '6':
				System.out.println("\n谢谢使用！");
				return;
			}
		}
		
	}
	
	public void addGoods(int id) {
		
	}
	
	public void listAllGoods() {}
	public void listGoodsById(int id) {}
	public void addToShoppingCart(int id, int count) {}
	public void listShoppingCart() {}
}
