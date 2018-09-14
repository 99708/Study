package com.xyq.dao.impl;

import java.util.ArrayList;

import com.xyq.dao.StudentDao;
import com.xyq.entity.Student;
import com.xyq.util.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public ArrayList<Student> listStudent(int minage, int maxage) {
		String sql = "select * from student where sage >= ? and sage <= ?";
		ArrayList<Student> als = new ArrayList<Student>();
		als = DBUtil.executeSelect(sql, new Student(), minage, maxage);
		return als;
	}

	@Override
	public void add(int sid, String sname, int sage, String ssex, String phone, String birthday, int cid) {
		String sql = "insert into student values(?, ?, ?, ?, ?, ?, ?)";
		DBUtil.executeDML(sql, sid, sname, sage, ssex, phone, birthday, cid);
	}

	@Override
	public int delete(int sid) {
		String sql = "delete from student where sid = ?";
		return DBUtil.executeDML(sql, sid);
	}

	@Override
	public int update(int sid, String NewName) {
		String sql = "update student set sname = ? where sid = ?";
		return DBUtil.executeDML(sql, NewName, sid);
	}

}
