package com.resj12.dao;

import java.util.List;

import com.resj12.vo.Users;
import com.wsm.db.DBManager;
import com.wsm.mapper.UsersMapper;

public class UsersDAO {
	public int addUser(Users user) {
		DBManager db=new DBManager();
		String sql="insert into users values(seq.nextval,?,?,to_date(?,'yyyy-MM-dd hh24:mi:ss'),?,?,?,?,?,to_date(?,'yyyy-MM-dd'))";
		Object params[]= {user.getUsername(),user.getUserpass(),user.getRegisterdate(),user.getSex(),user.getAddress(),user.getQq(),user.getEmail(),user.getLoves(),user.getBirthday()};
		return db.executeUpdate(sql, params);		
	}
	public Users findByUserid(int userid) {
		
		DBManager db=new DBManager();
		String sql="select * from users where userid=?";
		Object params[]= {userid};
		UsersMapper mapper=new UsersMapper();
		List<Users> list=db.executeQuery(sql, mapper, params);
		return list.get(0);
		
	}
	public Users findByName(String name,String userpass) {
		DBManager db=new DBManager();
		String sql="select * from users where username=? and userpass=?";
		Object params[]= {name,userpass};
		UsersMapper mapper=new UsersMapper();
		List<Users> list=db.executeQuery(sql, mapper, params);
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}
}
