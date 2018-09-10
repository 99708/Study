package com.xyq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xyq.entity.Dept;

public class Demo_Sel {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、加载驱动
		Class.forName("oracle.jdbc.OracleDriver");
		//2、获取连接
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:ORCL",
				"scott", "tiger");
		//3、创建SQL执行器
		Statement statement = conn.createStatement();
		//4、执行sql
		String sql = "select * from dept";
		ResultSet rs = statement.executeQuery(sql);
		ArrayList<Dept> lists = new ArrayList<Dept>();
		while(rs.next()) {
			Dept d = new Dept();
			d.setDeptno(rs.getInt("deptno"));
			d.setDname(rs.getString("dname"));
			d.setLoc(rs.getString("loc"));
			lists.add(d);
		}
		System.out.println(lists);
	}
}
