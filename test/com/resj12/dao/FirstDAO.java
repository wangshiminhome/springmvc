package com.resj12.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.resj12.vo.LoginMessage;
import com.resj12.vo.Messages;
import com.resj12.vo.Users;

public class FirstDAO {
	@Test
	public void first(){
		UsersDAO dao=new UsersDAO();
		Users user=new Users();
		user.setUsername("王士敏");
		user.setUserpass("0000");
		user.setRegisterdate("20160606 181212");
		user.setSex("男");
		user.setAddress("山东济南");
		user.setQq("296668498");
		user.setEmail("296668498@qq.com");
		user.setLoves("1211");
		user.setBirthday("20160102");
		int i=dao.addUser(user);
		System.out.println(i);
	}
	/*@Test
	public void second() {
		UsersDAO dao=new UsersDAO();
		String id="0";
		Users user=dao.findByUserid(id);
		System.out.println(user.getUsername());
	}*/
	@Test
	public void third() {
		Date date=new Date();
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String str=sdft.format(date);
		System.out.println(str);
		String arr[]=str.split("-");
		String by="";
		int len=arr.length;
		for(int i=0;i<len;i++) {
			by=by+arr[i];
		}
		System.out.println(by);
		String str3 = by.replaceAll(" ", "");
		System.out.println(str3);
		
	}
	@Test
	public void four() {
		MessageDAO dao=new MessageDAO();
		List<Messages> list=dao.findAll();
		System.out.println(list.size());
	}
	@Test
	public void five() {
		LoginMessageDAO dao=new LoginMessageDAO();
		List<LoginMessage> list=dao.findAll();
		System.out.println(list.size());
	}
}
