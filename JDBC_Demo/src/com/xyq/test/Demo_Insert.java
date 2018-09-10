package com.xyq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_Insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:ORCL", 
				"scott", "tiger");
		Statement statement = conn.createStatement();
		String sql = "insert into dept values(50, '997', '北京')";
		int n = statement.executeUpdate(sql);
		System.out.println(n);
		
	}
}
