package com.xyq.dao;

import java.util.ArrayList;

import com.xyq.entity.Student;

public interface StudentDao {

	
	public ArrayList<Student> listStudent(int minage, int maxage);

	public void add(int sid, String sname, int sage, String ssex, String phone, String birthday, int cid);

	public int delete(int sid);

	public int update(int sid, String sname);

}
