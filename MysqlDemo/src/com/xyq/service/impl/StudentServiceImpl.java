package com.xyq.service.impl;

import java.util.ArrayList;

import com.xyq.dao.StudentDao;
import com.xyq.dao.impl.StudentDaoImpl;
import com.xyq.entity.Student;
import com.xyq.service.StudentService;
import com.xyq.util.TSUtility;

public class StudentServiceImpl implements StudentService {

	StudentDao sd = new StudentDaoImpl();
	
	@Override
	public void listStudent() {
		System.out.println("请输入年龄下限");
		int minage = TSUtility.readInt();
		System.out.println("请输入年龄上限");
		int maxage = TSUtility.readInt();
		ArrayList<Student> ls = new ArrayList<Student>();
		ls = sd.listStudent(minage, maxage);
		System.out.println(ls);
	}

	@Override
	public void add() {
		ArrayList<Student> ls = new ArrayList<Student>();
		System.out.print("请输入学生的学号：");
		int sid = TSUtility.readInt();
		ls = sd.listStudent(18, 23);
		for(Student s:ls) {
			if(s.getSid() == sid) {
				System.out.println("你的输入有误，请检查你的输入");
				return;
			}
		}
		System.out.print("请输入学生的姓名：");
		String sname = TSUtility.readString();
		System.out.print("请输入学生的年龄：");
		int sage = TSUtility.readInt();
		System.out.print("请输入学生的性别：");
		String ssex = TSUtility.readString();
		System.out.print("请输入学生的电话号码：");
		String phone = TSUtility.readString();
		System.out.print("请输入学生的生日：例如(yyyy-mm-dd)");
		String birthday = TSUtility.readString();
		System.out.print("请输入学生的课程号：");
		int cid = TSUtility.readInt();
		sd.add(sid, sname, sage, ssex, phone, birthday, cid);
	}

	@Override
	public void delete() {
		System.out.println("请输入要删除的学生的学号");
		int sid = TSUtility.readInt();
		int i = sd.delete(sid);
		if(i > 0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void update() {
		System.out.println("请输入要修改的学生的学号");
		int sid = TSUtility.readInt();
		System.out.println("请输入新值");
		String sname = TSUtility.readString();
		int i = sd.update(sid, sname);
		if(i > 0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}

}
