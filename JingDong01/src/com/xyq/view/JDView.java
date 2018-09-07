package com.xyq.view;

import com.xyq.service.GoodsService;
import com.xyq.service.ShoppingCartService;
import com.xyq.util.TSUtility;

public class JDView {
	
	private GoodsService gs = new GoodsService();
	private ShoppingCartService scs = new ShoppingCartService();
	
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
				gs.addGoods();
				break;
			case '2':
				gs.listAllGoods();
				break;
			case '3':
				gs.listGoodsById();
				break;
			case '4':
				scs.addToShoppingCart();
				break;
			case '5':
				scs.listShoppingCart();
				break;
			case '6':
				System.out.println("谢谢使用！");
				return;
			}
		}
		
	}
	
}
