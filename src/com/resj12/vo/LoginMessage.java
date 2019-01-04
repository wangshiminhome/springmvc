package com.resj12.vo;

public class LoginMessage {
	private int limid;
	private int userid; 
	private String limdate;
	private String loginip;
	public int getLimid() {
		return limid;
	}
	public void setLimid(int limid) {
		this.limid = limid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getLimdate() {
		return limdate;
	}
	public void setLimdate(String limdate) {
		this.limdate = limdate;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public LoginMessage(int limid, int userid, String limdate, String loginip) {
		super();
		this.limid = limid;
		this.userid = userid;
		this.limdate = limdate;
		this.loginip = loginip;
	}
	public LoginMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
