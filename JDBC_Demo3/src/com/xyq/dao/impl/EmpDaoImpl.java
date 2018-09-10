package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xyq.dao.EmpDao;
import com.xyq.entity.Emp;
import com.xyq.util.DBUtil;

public class EmpDaoImpl implements EmpDao{
	
	/**
	 * 根据员工的员工号查询员工信息
	 * @param empno
	 * @return
	 */
	public Emp findEmpByEmpno(int empno) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		
		try {
			//1、获取连接
			conn = DBUtil.getConnection();
			//2、创建sql
			String sql = "select * from emp where empno = ?";	
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
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		ArrayList<Emp> lists = new ArrayList<Emp>();
		
		try {
			//1、获取连接
			conn = DBUtil.getConnection();
			//2、创建sql
			String sql = "select * from emp";
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
		
		String sql = "update emp set ename = ? where empno = ?";
		return DBUtil.executeDML(sql, newName, empno);
	}
	
	/**
	 * 根据员工号删除员工信息
	 * @param empno
	 * @return
	 */
	public int deleteEmpByEmpno(int empno) {
		return DBUtil.executeDML("delete from emp where empno = ?", empno);
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
		String sql = "insert into emp values(?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'), ?, ?, ?)";
		return DBUtil.executeDML(sql, empno, ename, job, mgr, hiredate, sal, comm, deptno); 
	}
	
}
	
