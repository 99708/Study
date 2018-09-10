package com.xyq.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.xyq.entity.Goods;

public class GoodsDao {
	
	private Goods goods;
	private static File file;
	//商品列表只能有一份
	static {
		file = new File("Goods.txt");
		if(!file.exists()) {//如果文件不存在创建文件
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
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
		
		String str = goods.getId()+"#"+goods.getName()+"#"
		+goods.getPrice()+"#"+goods.getColor()+"#"+goods.getSize()+"#"
		+goods.getStock();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(str);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * 查看所有商品
	 * @return 
	 */
	public ArrayList<Goods> listAllGoods() {
		
		ArrayList<Goods> lists = new ArrayList<Goods>();
		BufferedReader br = null;
		
		try {
			 br = new BufferedReader(new FileReader(file));
			 String str = br.readLine();
			 while(str != null) {
				 String[] s = str.split("#");
				 goods = new Goods();
				 goods.setId(Integer.parseInt(s[0]));
				 goods.setName(s[1]);
				 goods.setPrice(Float.parseFloat(s[2]));
				 goods.setColor(s[3]);
				 goods.setSize(Float.parseFloat(s[4]));
				 goods.setStock(Integer.parseInt(s[5]));
				 lists.add(goods);
				 str = br.readLine();
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}
	
	/**
	 * 通过id查询商品
	 * @param id 商品id
	 * @return 是否添加成功
	 */
	public Goods listGoodsById(int id) {
		Goods g = null;
		ArrayList<Goods> goodsLits = listAllGoods();
		Iterator<Goods> it = goodsLits.iterator();
		while(it.hasNext()) {
			g = (Goods) it.next();
			if(g.getId() == id) return g;	//返回查询到的商品 
		}
		return null;
	}
	
}
