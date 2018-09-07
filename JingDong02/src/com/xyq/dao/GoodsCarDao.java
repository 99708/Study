package com.xyq.dao;

import java.util.ArrayList;

import com.xyq.entity.Goods;
import com.xyq.entity.ShoppingCartItem;

public class GoodsCarDao {
	//每个用户各有一个购物车
	private ArrayList<ShoppingCartItem> goodsCarts = new ArrayList<ShoppingCartItem>(); //购物车
	private GoodsDao gd = new GoodsDao();
	
	/**
	 * 添加到购物车
	 * @param id 商品id
	 * @param count 商品数量
	 */
	public void addToShoppingCart(int id, int count) {
		Goods g = gd.listGoodsById(id);
		ShoppingCartItem sci = new ShoppingCartItem(g.getId(), g.getName(), g.getPrice(), count);
		goodsCarts.add(sci);
	}
	
	/**
	 * 展现购物车中的商品
	 * @return 
	 */
	public ArrayList<ShoppingCartItem> listShoppingCart() {
		if(goodsCarts.size() > 0) {
			return goodsCarts;
		}
		return null;
	}
}
