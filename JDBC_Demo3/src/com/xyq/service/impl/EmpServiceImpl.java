package com.xyq.service.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.xyq.dao.EmpDao;
import com.xyq.dao.impl.EmpDaoImpl;
import com.xyq.entity.Emp;
import com.xyq.service.EmpService;

public class EmpServiceImpl implements EmpService {
	
	EmpDao empDao = new EmpDaoImpl();
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 根据员工的员工号查询员工信息
	 */
	public void findEmpByEmpno() {
		System.out.println("请输入员工的员工号：");
		int empno = sc.nextInt();
		Emp emp = empDao.findEmpByEmpno(empno);
		if(emp == null) {
			System.out.println("没有该员工");
		}else {
			System.out.println(emp);
		}
		
	}
	
	/**
	 * 查询员工的所有信息
	 */
	public void findEmp() {
		ArrayList<Emp> emps = empDao.findEmp();
		System.out.println(emps);
	}
	
	/**
	 * 根据员工的员工号更新员工的姓名
	 */
	public void upEmpByEmpno() {
		System.out.println("情输入你要更改的员工的员工号");
		int empno = sc.nextInt();
		System.out.println("请输入新的员工姓名");
		String newName = sc.next();
		if(empDao.upEmpByEmpno(empno, newName) > 0) {
			System.out.println("更新成功");
		}
	}
	
	/**
	 * 根据员工编号删除员工
	 */
	public void deleteEmpByEmpno() {
		System.out.println("情输入你要删除的员工的员工号");
		int empno = sc.nextInt();
		if(empDao.deleteEmpByEmpno(empno) > 0) {
			System.out.println("删除成功");
		}
	}
	
	/**
	 * 根据输入的员工信息添加员工
	 */
	public void addEmp() {
		System.out.println("请输入员工信息以空格隔开：");
		System.out.println("员工编号\t员工姓名\t员工工作\t员工上级编号\t员工入职时间\t基本工资\t奖金\t部门编号");
		int empno = sc.nextInt();
		String ename = sc.next();
		String job = sc.next();
		int mgr = sc.nextInt();
		String hiredate = sc.next();
		double sal = sc.nextDouble();
		double comm = sc.nextDouble();
		int deptno = sc.nextInt();
		if(empDao.addEmp(empno, ename, job, mgr, hiredate, sal, comm, deptno) > 0) {
			System.out.println("添加成功");
		}
	}
}
