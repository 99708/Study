package com.xyq.dao;

import java.util.ArrayList;

import com.xyq.entity.Emp;

public interface EmpDao {
	
	/**
	 * 根据员工的员工号查询员工信息
	 * @param empno
	 * @return
	 */
	public Emp findEmpByEmpno(int empno);
	
	/**
	 * 查询员工的所有信息
	 * @return
	 */
	public ArrayList<Emp> findEmp();
	
	/**
	 * 根据员工的员工号更新员工的姓名
	 * @param empno
	 * @param newName
	 * @return
	 */
	public int upEmpByEmpno(int empno, String newName);
	
	/**
	 * 根据员工号删除员工信息
	 * @param empno
	 * @return
	 */
	public int deleteEmpByEmpno(int empno);
	
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
	
	public int addEmp(int empno, String ename, String job, int mgr, String hiredate, double sal,double comm, int deptno);

}
		
	

