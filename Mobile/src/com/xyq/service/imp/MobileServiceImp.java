package com.xyq.service.imp;

import java.util.List;

import com.xyq.dao.MobileDao;
import com.xyq.dao.imp.MobileDaoImp;
import com.xyq.entity.Mobile;
import com.xyq.service.MobileService;
import com.xyq.util.TSUtility;

public class MobileServiceImp implements MobileService {
	
	MobileDao mobileDao = new MobileDaoImp();
	
	@Override
	public void add() {
		System.out.println("请输入手机品牌：");
		String brand = TSUtility.readString();
		System.out.println("请输入手机型号：");
		String model = TSUtility.readString();
		System.out.println("请输入手机价格：");
		int price = TSUtility.readInt();
		System.out.println("请输入手机数量：");
		int count = TSUtility.readInt();
		System.out.println("请输入手机版本：");
		String version = TSUtility.readString();
		mobileDao.add(brand, model, price, count, version);
	}

	@Override
	public Mobile findByBrand() {
		System.out.println("请输入手机品牌：");
		String brand = TSUtility.readString();
		Mobile mobile = mobileDao.findByBrand(brand);
		return mobile;
	}

	@Override
	public List<Mobile> list() {
		List<Mobile> list = mobileDao.list();
		return list;
	}

	@Override
	public int updatePriceById() {
		System.out.println("请输入手机的编号：");
		int id = TSUtility.readInt();
		System.out.println("请输入新的价格：");
		int price = TSUtility.readInt();
		int result = mobileDao.updatePriceById(id, price);
		return result;
	}

	@Override
	public int deleteById() {
		System.out.println("请输入手机的编号：");
		int id = TSUtility.readInt();
		int result = mobileDao.deleteById(id);
		return result;
	}

}
