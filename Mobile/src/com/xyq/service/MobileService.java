package com.xyq.service;

import java.util.List;

import com.xyq.entity.Mobile;

public interface MobileService {

	/**
	 * 添加手机信息
	 */
	public void add();
	
	/**
	 * 根据手机型号查询手机信息
	 * @return
	 */
	public Mobile findByBrand();

	/**
	 * 查询全部手机信息
	 * @return
	 */
	public List<Mobile> list();

	/**
	 * 根据id修改手机的价格
	 * @return
	 */
	public int updatePriceById();

	/**
	 * 根据手机编号删除手机信息
	 * @return
	 */
	public int deleteById();

}
