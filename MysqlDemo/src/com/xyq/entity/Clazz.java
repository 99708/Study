package com.xyq.entity;

public class Clazz {
	
	private Integer cid;
	private String cname;
	
	public Integer getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Clazz() {}
	
	public Clazz(Integer cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "Clazz [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
