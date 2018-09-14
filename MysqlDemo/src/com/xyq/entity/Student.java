package com.xyq.entity;

import java.sql.Date;

public class Student {
	
	private Integer sid;
	private String sname;
	private Integer sage;
	private String ssex;
	private String phone;
	private Date birthday;
	private Integer cid;
	
	public Integer getSid() {
		return sid;
	}
	public String getSname() {
		return sname;
	}
	public Integer getSage() {
		return sage;
	}
	public String getSsex() {
		return ssex;
	}
	public String getPhone() {
		return phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Integer getCid() {
		return cid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Student() {
	}
	
	public Student(Integer sid, String sname, Integer sage, String ssex, String phone, Date birthday, Integer cid) {
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.phone = phone;
		this.birthday = birthday;
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", ssex=" + ssex + ", phone=" + phone
				+ ", birthday=" + birthday + ", cid=" + cid + "]";
	}
	
}
