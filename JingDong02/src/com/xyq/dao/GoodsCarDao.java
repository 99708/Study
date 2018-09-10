package com.xyq.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.xyq.entity.Goods;
import com.xyq.entity.ShoppingCartItem;

public class GoodsCarDao {
	//每个用户各有一个购物车
	private static File file;
	private GoodsDao gd = new GoodsDao();
	static {
		file = new File("GoodsCar.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 添加到购物车
	 * @param id 商品id
	 * @param count 商品数量
	 */
	public void addToShoppingCart(int id, int count) {
		Goods g = gd.listGoodsById(id);
		String str = g.getId()+"#"+g.getName()+"#"+g.getPrice()+"#"+ count;
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
	}
	
	/**
	 * 展现购物车中的商品
	 * @return 
	 */
	public ArrayList<ShoppingCartItem> listShoppingCart() {
		ArrayList<ShoppingCartItem> lists = new ArrayList<ShoppingCartItem>();
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			while(str != null) {
				String[] s = str.split("#");
				ShoppingCartItem sci = new ShoppingCartItem();
				sci.setId(Integer.parseInt(s[0]));
				sci.setName(s[1]);
				sci.setPrice(Float.parseFloat(s[2]));
				sci.setAmount(Integer.parseInt(s[3]));
				lists.add(sci);
				str = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lists;
	}
}
