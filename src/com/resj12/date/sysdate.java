package com.resj12.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sysdate {
	public String dateTime1() {
		Date date=new Date();
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String str=sdft.format(date);
		String arr[]=str.split("-");
		String by="";
		int len=arr.length;
		for(int i=0;i<len;i++) {
			by=by+arr[i];
		}
		return by;
	}
	public String dateTime2() {

		return dateTime1().replaceAll(" ", "");
	}
	public String dateTime3(String time) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		
			Date date;
			try {
				date = df.parse(time);
				String str=d.format(date);
				return str;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return null;
		
	}
}
