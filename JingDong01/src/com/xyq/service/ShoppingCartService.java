package com.xyq.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.xyq.dao.GoodsCarDao;
import com.xyq.dao.GoodsDao;
import com.xyq.entity.ShoppingCartItem;
import com.xyq.util.TSUtility;

public class ShoppingCartService {
	private GoodsCarDao gcd = new GoodsCarDao();
	private GoodsDao gd = new GoodsDao();
	/**
	 * 添加到购物车
	 * @param id 商品id
	 * @param count 商品数量
	 */
	public void addToShoppingCart() {
		System.out.println("请输入商品编号");
		int id = TSUtility.readInt();
		if(gd.listGoodsById(id) == null) {
			System.out.println("添加的商品不存在");
			return;
		}	
		System.out.println("请输入商品数量");
		int count = TSUtility.readInt();
		gcd.addToShoppingCart(id, count);
		System.out.println("添加成功");
	}
	
	/**
	 * 展现购物车中的商品
	 * @return 
	 */
	public void listShoppingCart() {
		float count = 0;
		ArrayList<ShoppingCartItem> goodsCarts = gcd.listShoppingCart();
		if (goodsCarts != null) {
			System.out.println("编号\t商品名称\t\t商品价格\t数量\t小计");
			Iterator<ShoppingCartItem> it = goodsCarts.iterator();
			while(it.hasNext()) {
				ShoppingCartItem sci = (ShoppingCartItem) it.next();
				System.out.println(sci.getId()+"\t"+sci.getName()+"\t"+sci.getPrice()+"\t"+
				sci.getAmount()+"\t"+(sci.getAmount()*sci.getPrice()));
				count= count + (sci.getAmount()*sci.getPrice());
			}
			System.out.println("总计：" + count);
		}else {
			System.out.println("空空如也");
		}
	}
}
