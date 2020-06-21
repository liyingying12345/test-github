package com.liyingying.beans;

public class Goods {

	private Integer gid;
	private String gname;
	private String gtime;
	private String cid;
	
	//临时字段
	private String cname;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGtime() {
		return gtime;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public Goods(Integer gid, String gname, String gtime, String cid, String cname) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gtime = gtime;
		this.cid = cid;
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gtime=" + gtime + ", cid=" + cid + ", cname=" + cname
				+ "]";
	}
	public Goods() {
		super();
	}
}
