package com.xyq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xyq.dao.MobileDao;
import com.xyq.entity.Mobile;
import com.xyq.util.DBUtil;

public class MobileDaoImp implements MobileDao {

	@Override
	public void add(String brand, String model, int price, int count, String version) {
		String sql = "insert into mobile values(t_mobile_id_seq.nextval, ?, ?, ?, ?, ?)";
		DBUtil.executeDML(sql, brand, model, price, count, version);
	}

	@Override
	public Mobile findByBrand(String brand) {
		Mobile mobile = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1、获取连接
			conn = DBUtil.getConnection();
			//2、创建sql
			String sql = "select * from mobile where brand = ?";
			//3、创建SQL命令对象
			ps = conn.prepareStatement(sql);
			//4、给占位符赋值
			ps.setString(1, brand);
			//5、执行SQL命令
			rs = ps.executeQuery();
			//6、遍历
			while(rs.next()) {
				mobile = new Mobile();
				mobile.setId(rs.getInt("id"));
				mobile.setBrand(rs.getString("brand"));
				mobile.setModel(rs.getString("model"));
				mobile.setPrice(rs.getInt("price"));
				mobile.setCount(rs.getInt("count"));
				mobile.setVersion(rs.getString("version"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		return mobile;
	}

	@Override
	public List<Mobile> list() {
		List<Mobile> lists = new ArrayList<Mobile>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1、获取连接
			conn = DBUtil.getConnection();
			//2、创建sql
			String sql = "select * from mobile";
			//3、创建SQL命令对象
			ps = conn.prepareStatement(sql);
			//4、给占位符赋值
			//5、执行SQL命令
			rs = ps.executeQuery();
			//6、遍历
			while(rs.next()) {
				Mobile mobile = new Mobile();
				mobile.setId(rs.getInt("id"));
				mobile.setBrand(rs.getString("brand"));
				mobile.setModel(rs.getString("model"));
				mobile.setPrice(rs.getInt("price"));
				mobile.setCount(rs.getInt("count"));
				mobile.setVersion(rs.getString("version"));
				lists.add(mobile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		return lists;
	}

	@Override
	public int updatePriceById(int id, int price) {
		String sql = "update mobile set price = ? where id = ?";
		int result = DBUtil.executeDML(sql, price, id);
		return result;
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from mobile where id = ?";
		int result = DBUtil.executeDML(sql, id);
		return result;
	}

}
