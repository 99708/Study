package com.xyq.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.xyq.entity.Goods;

public class GoodsDao {
	
	private Goods goods;
	//商品列表只能有一份
	public static ArrayList<Goods> goodsLits = new ArrayList<Goods>(); //商品集合
	
	/**
	 * 添加商品
	 * @return 
	 */
	public boolean addGoods(int id, String name, float price, String color, float size, int stock) {
		
		goods = new Goods();
		goods.setId(id);
		goods.setName(name);
		goods.setPrice(price);
		goods.setColor(color);
		goods.setSize(size);
		goods.setStock(stock);
		goodsLits.add(goods);
		return true;
	}
	
	/**
	 * 查看所有商品
	 * @return 
	 */
	public ArrayList<Goods> listAllGoods() {
		if(goodsLits.size() > 0) {
			return goodsLits;
		}
		return null;
	}
	
	/**
	 * 通过id查询商品
	 * @param id 商品id
	 * @return 是否添加成功
	 */
	public Goods listGoodsById(int id) {
		Goods g = null;
		Iterator<Goods> it = goodsLits.iterator();
		while(it.hasNext()) {
			g = (Goods) it.next();
			if(g.getId() == id) return g;	//返回查询到的商品 
		}
		return null;
	}
	
}
