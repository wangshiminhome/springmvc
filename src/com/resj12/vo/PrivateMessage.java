package com.resj12.vo;

public class PrivateMessage {
	private int mid;
	private int senderid;
	private int accepterid;
	private String pmcontent;
	private String pmdate;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getSenderid() {
		return senderid;
	}
	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}
	public int getAccepterid() {
		return accepterid;
	}
	public void setAccepterid(int accepterid) {
		this.accepterid = accepterid;
	}
	public String getPmcontent() {
		return pmcontent;
	}
	public void setPmcontent(String pmcontent) {
		this.pmcontent = pmcontent;
	}
	public String getPmdate() {
		return pmdate;
	}
	public void setPmdate(String pmdate) {
		this.pmdate = pmdate;
	}
	public PrivateMessage(int mid, int senderid, int accepterid, String pmcontent, String pmdate) {
		super();
		this.mid = mid;
		this.senderid = senderid;
		this.accepterid = accepterid;
		this.pmcontent = pmcontent;
		this.pmdate = pmdate;
	}
	public PrivateMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
