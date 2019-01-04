package com.resj12.dao;

import java.util.List;

import com.resj12.vo.Messages;
import com.wsm.db.DBManager;
import com.wsm.mapper.MessagesMapper;


public class MessageDAO {
	//添加
	public int addMessage(Messages message) {
		DBManager db=new DBManager();
		String sql="insert into message values(seq2.nextval,?,?,to_date(?,'yyyy-MM-dd hh24:mi:ss'))";
		Object params[]= {message.getUserid(),message.getMcontent(),message.getMdate()};
		return db.executeUpdate(sql, params);		
	}
	//通过mid查询
	public Messages findByUserid(int mid) {
		
		DBManager db=new DBManager();
		String sql="select * from message where userid=?";
		Object params[]= {mid};
		MessagesMapper mapper=new MessagesMapper();
		List<Messages> list=db.executeQuery(sql, mapper, params);
		return list.get(0);
	}
	//查询所有
	public List<Messages> findAll(){
		DBManager db=new DBManager();
		String sql="select * from message";
		MessagesMapper mapper=new MessagesMapper();
		return db.executeQuery(sql, mapper, null);
		
	}
}
