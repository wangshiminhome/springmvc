package com.wsm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.resj12.vo.LoginMessage;

public class LoginMessageMapper implements IMapper{

	@Override
	public List<LoginMessage> map(ResultSet rs) {
		List<LoginMessage> list=new ArrayList<>();
		try {
			while(rs.next()) {
				 int limid=rs.getInt("LMID");
				 int userid=rs.getInt("USERID"); 
				 String imdate=rs.getString("IMDATE");
				 String loginip=rs.getString("LOGINIP");
				LoginMessage lm=new LoginMessage(limid, userid, imdate, loginip);
				list.add(lm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
