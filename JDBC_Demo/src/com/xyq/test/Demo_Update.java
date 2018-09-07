package com.xyq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_Update {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、加载驱动
		Class.forName("oracle.jdbc.OracleDriver");
		//2、获取连接
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:ORCL", 
				"scott", "tiger");
		//3、创建SQL命令执行器
		Statement statement = conn.createStatement();
		String sql = "update dept set loc = '上海'  where deptno = 50";
		int n = statement.executeUpdate(sql);
		System.out.println(n);
		
	}
}
