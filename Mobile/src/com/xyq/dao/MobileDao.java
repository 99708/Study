package com.xyq.dao;

import java.util.List;

import com.xyq.entity.Mobile;

public interface MobileDao {
	/**
	 * 添加手机信息
	 * @param brand
	 * @param model
	 * @param price
	 * @param count
	 * @param version
	 */
	public void add(String brand, String model, int price, int count, String version);
	
	/**
	 * 根据手机型号查询手机信息
	 * @param brand
	 * @return
	 */
	public Mobile findByBrand(String brand);
	
	/**
	 * 查询全部手机信息
	 * @return
	 */
	public List<Mobile> list();
	
	/**
	 * 根据id修改手机的价格
	 * @param id
	 * @param price
	 * @return
	 */
	public int updatePriceById(int id, int price);

	/**
	 * 根据手机编号删除手机信息
	 * @param id
	 * @return
	 */
	public int deleteById(int id);

}
