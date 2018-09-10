package com.xyq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	//1、定义jdbc参数变量
	private static String Driver;
	private static String Url;
	private static String UserName;
	private static String PassWord;
	
	
	//2、使用静态块获取配置文件中的数据库参数
	static {
		
		Properties pro = new Properties();
		//获取配置文件的流对象
		InputStream is = DBUtil.class.getResourceAsStream("/db.properties");
		try {
			
			//解析加载配置文件中的数据
			pro.load(is);
			
			//获取解析好的数据并赋值给属性完成初始化
			Driver = pro.getProperty("Driver");
			Url = pro.getProperty("Url");
			UserName = pro.getProperty("UserName");
			PassWord= pro.getProperty("PassWord");
			
			//加载驱动
			Class.forName(Driver);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//3、获取连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(Url, UserName, PassWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//4、关闭操作
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
	//增删改操作
	public static int executeDML (String sql, Object...objs) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1、获取连接
			conn = getConnection();
			conn.setAutoCommit(false);
			//2、创建sql(传进来)
			//3、创建sql命令对象
			 ps = conn.prepareStatement(sql);
			 for(int i=0; i<objs.length; i++) {
				 ps.setObject(i+1, objs[i]);
			 }
			//4、执行sql命令
			int i = ps.executeUpdate();
			conn.commit();
			return i;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
}
