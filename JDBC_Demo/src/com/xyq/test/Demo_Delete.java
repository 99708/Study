package com.xyq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_Delete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、加载驱动
		Class.forName("oracle.jdbc.OracleDriver");
		//2、获取连接
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:ORCL",
				"scott", "tiger");
		//3、创建SQL执行器
		Statement stment = conn.createStatement();
		String sql = "delete from dept where deptno = 50";
		//4、执行SQL语句
		int n = stment.executeUpdate(sql);
		System.out.println(n);
	}
}
