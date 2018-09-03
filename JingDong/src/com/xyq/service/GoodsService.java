package com.xyq.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.xyq.entity.Goods;
import com.xyq.util.TSUtility;

public class GoodsService {
	
	private Goods goods;
	ArrayList<Goods> goodsLits = new ArrayList<Goods>(); //商品集合
	ArrayList<Goods> goodsCarts = new ArrayList<Goods>(); //购物车
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	/**
	 * 添加商品
	 * @return 是否添加成功
	 */
	public boolean addGoods() {
		System.out.println("请输入商品编号");
		goods.setId(TSUtility.readInt());
		if(listGoodsById(goods.getId()) != null) return false; //id重复是添加失败
		System.out.println("请输入商品名称");
		goods.setName(TSUtility.readString());
		System.out.println("请输入商品价格");
		goods.setPrice(TSUtility.readFloat());
		System.out.println("请输入商品颜色");
		goods.setColor(TSUtility.readString());
		System.out.println("请输入商品尺寸");
		goods.setSize(TSUtility.readFloat());
		System.out.println("请输入商品库存");
		goods.setStock(TSUtility.readInt());
		goodsLits.add(goods);
		return true;
	}
	
	/**
	 * 查看所有商品
	 */
	public void listAllGoods() {
		Iterator<Goods> it = goodsLits.iterator();
		while(it.hasNext()) {
			Goods g = (Goods) it.next();
			System.out.println(g);
		}
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
		return g;
	}
	public void addToShoppingCart(int id, int count) {
		Goods g;
		if((g = listGoodsById(id)) != null);
		for(int i=0; i<count; i++) {
			goodsCarts.add(g);
		}
	}
	public void listShoppingCart() {
		String str = ""
	}

}
