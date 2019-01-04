package com.resj12.dao;

import java.util.List;

import com.resj12.vo.LoginMessage;
import com.wsm.db.DBManager;
import com.wsm.mapper.LoginMessageMapper;

public class LoginMessageDAO {
	public List<LoginMessage> findAll(){
		DBManager db=new DBManager();
		String sql="select * from loginmessage";
		LoginMessageMapper mapper=new LoginMessageMapper();
		return db.executeQuery(sql, mapper, null);
	}
	public int add(LoginMessage lm) {
		DBManager db=new DBManager();
		String sql="insert into loginmessage values(seq2.nextval,?,to_date(?,'yyyy-MM-dd hh24-mi-ss'),?)";
		Object params[]= {lm.getUserid(),lm.getLimdate(),lm.getLoginip()};
		return db.executeUpdate(sql, params);
	}
}
