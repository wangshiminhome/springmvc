package com.resj12.vo;

public class Messages {
	private int mid;
	private int userid;
	private String mcontent;
	private String mdate;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public Messages(int mid, int userid, String mcontent, String mdate) {
		super();
		this.mid = mid;
		this.userid = userid;
		this.mcontent = mcontent;
		this.mdate = mdate;
	}
	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
