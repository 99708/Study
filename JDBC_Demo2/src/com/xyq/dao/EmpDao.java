package com.xyq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.xyq.entity.Emp;

public class EmpDao {
	/**
	 * 数据库的连接
	 * @return Connection对象
	 */
	public Connection getConn() {
		//1、定义数据库连接变量
		Connection conn = null;
		try {
			//1、加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			//2、获取连接
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL",
					"scott", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 根据员工的员工号查询员工信息
	 * @param empno
	 * @return
	 */
	public Emp findEmpByEmpno(int empno) {
		
		//1、得到连接
		Connection conn = this.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、创建sql
		String sql = "select * from emp where empno = ?";
		Emp emp = null;
		
		try {
			//3、创建sql命令对象
			 ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			//4、执行sql命令
			rs = ps.executeQuery();
			//5、遍历
			while(rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
		return emp;
		
	}
	
	/**
	 * 查询员工的所有信息
	 * @return
	 */
	public ArrayList<Emp> findEmp(){
		//1、得到连接
		Connection conn = this.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、创建sql
		String sql = "select * from emp";
		Emp emp = null;
		ArrayList<Emp> lists = new ArrayList<Emp>();
		try {
			//3、创建sql命令对象
			 ps = conn.prepareStatement(sql);
			//4、执行sql命令
			rs = ps.executeQuery();
			//5、遍历
			while(rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				lists.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
		return lists;
	}
	
	/**
	 * 根据员工的员工号更新员工的姓名
	 * @param empno
	 * @param newName
	 * @return
	 */
	public int upEmpByEmpno(int empno, String newName) {
		//1、得到连接
		Connection conn = this.getConn();
		PreparedStatement ps = null;
		//2、创建sql
		String sql = "update emp set ename = ? where empno = ?";
		try {
			conn.setAutoCommit(false);
			//3、创建sql命令对象
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, newName);
			 ps.setInt(2, empno);
			//4、执行sql命令
			int i = ps.executeUpdate();
			conn.commit();
			return i;
		} catch (SQLException e) {
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
	
	/**
	 * 根据员工号删除员工信息
	 * @param empno
	 * @return
	 */
	public int deleteEmpByEmpno(int empno) {
		//1、得到连接
		Connection conn = this.getConn();
		PreparedStatement ps = null;
		//2、创建sql
		String sql = "delete from emp where empno = ?";
		try {
			conn.setAutoCommit(false);
			//3、创建sql命令对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, empno);
			//4、执行sql命令
			int i = ps.executeUpdate();
			conn.commit();
			return i;
		} catch (SQLException e) {
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
	
	/**
	 * 根据输入的员工信息插入员工信息
	 * @param empno
	 * @param ename
	 * @param job
	 * @param mgr
	 * @param hiredate
	 * @param sal
	 * @param comm
	 * @param deptno
	 * @return
	 */
	
	public int addEmp(int empno, String ename, String job, int mgr, String hiredate, double sal,double comm, int deptno) {
		//1、得到连接
		Connection conn = this.getConn();
		PreparedStatement ps = null;
		//2、创建sql
		String sql = "insert into emp values(?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'), ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			//3、创建sql命令对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, empno);
			 ps.setString(2, ename);
			 ps.setString(3, job);
			 ps.setInt(4, mgr);
			 ps.setString(5, hiredate);
			 ps.setDouble(6, sal);
			 ps.setDouble(7, comm);
			 ps.setInt(8, deptno);
			//4、执行sql命令
			int i = ps.executeUpdate();
			conn.commit();
			return i;
		} catch (SQLException e) {
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
