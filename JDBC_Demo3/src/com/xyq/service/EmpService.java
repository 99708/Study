package com.xyq.service;

public interface EmpService {
	
	/**
	 * 根据员工的员工号查询员工信息
	 */
	public void findEmpByEmpno();
	
	/**
	 * 查询员工的所有信息
	 */
	public void findEmp();
	
	/**
	 * 根据员工的员工号更新员工的姓名
	 */
	public void upEmpByEmpno();
	
	/**
	 * 根据员工编号删除员工
	 */
	public void deleteEmpByEmpno();
	
	/**
	 * 根据输入的员工信息添加员工
	 */
	public void addEmp();
}
