package com.resj12.vo;

public class Users {
	private int userid;
	private String username;
	private String userpass;
	private String registerdate;
	private String  sex;
	private String address;
	private String qq;
	private String email;
	private String loves;
	private String birthday;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoves() {
		return loves;
	}
	public void setLoves(String loves) {
		this.loves = loves;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Users(int userid, String username, String userpass, String registerdate, String sex, String address,
			String qq, String email, String loves, String birthday) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.registerdate = registerdate;
		this.sex = sex;
		this.address = address;
		this.qq = qq;
		this.email = email;
		this.loves = loves;
		this.birthday = birthday;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
}
