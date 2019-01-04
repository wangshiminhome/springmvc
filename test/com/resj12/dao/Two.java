package com.resj12.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.resj12.vo.PrivateMessage;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Two {
	@Test
	public void tset() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String dateString = "20171122121547";

		try {
			Date date = df.parse(dateString);
			String str=d.format(date);
			System.out.println(str);
	
		} catch (Exception ex) {

		System.out.println(ex.getMessage());	
	}
	}
	@Test
	public void test() {
		int id=0;
		PrivateMessageDAO dao=new PrivateMessageDAO();
		List<PrivateMessage> list=dao.findById(id);
		System.out.println(list.size());
	}
}
