package com.xyq.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.xyq.dao.GoodsDao;
import com.xyq.entity.Goods;
import com.xyq.util.TSUtility;

public class GoodsService {
	
	GoodsDao gd = new GoodsDao();
	
	/**
	 * 添加商品
	 * @return 是否添加成功
	 */
	public void addGoods() {
		System.out.println("请输入商品编号");
		int id = TSUtility.readInt();
		if(gd.listGoodsById(id) != null) {
			System.out.println("添加失败");
			return ; //id重复是添加失败
		} 
			
		System.out.println("请输入商品名称");
		String name = TSUtility.readString();
		System.out.println("请输入商品价格");
		float price = TSUtility.readFloat();
		System.out.println("请输入商品颜色");
		String color = TSUtility.readString();
		System.out.println("请输入商品尺寸");
		float size = TSUtility.readFloat();
		System.out.println("请输入商品库存");
		int stock = TSUtility.readInt();
		if(gd.addGoods(id, name, price, color, size, stock)) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	
	/**
	 * 查看所有商品
	 * @return 
	 */
	public void listAllGoods() {
		ArrayList<Goods> goodsLits = gd.listAllGoods();
		if(goodsLits != null) {
			System.out.println("编号\t商品名称\t\t商品价格\t商品颜色\t商品尺寸\t商品库存");
			Iterator<Goods> it = goodsLits.iterator();
			while(it.hasNext()) {
				Goods g = (Goods) it.next();
				System.out.println(g);
			}
		}else {
			System.out.println("还没有商品，请先添加商品");
		}
	}
	
	/**
	 * 通过id查询商品
	 * @param id 商品id
	 * @return 是否添加成功
	 */
	public void listGoodsById() {
		
		Goods g;
		System.out.println("请输入商品编号");
		int id = TSUtility.readInt();
		if((g=gd.listGoodsById(id)) != null) {
			System.out.println("编号\t商品名称\t\t商品价格\t商品颜色\t商品尺寸\t商品库存");
			System.out.println(g);
		}else {
			System.out.println("该编号的商品不存在");
		}
	}
	
}
