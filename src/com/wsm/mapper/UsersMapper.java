package com.wsm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.resj12.vo.Users;

public class UsersMapper implements IMapper {

	@Override
	public List<Users> map(ResultSet rs) {
		List<Users> list=new ArrayList<>();
		try {
			while(rs.next()) {
				int userid=rs.getInt("USERID");
				String username=rs.getString("USERNAME");
				String userpass=rs.getString("USERPASS");
				String registerdate=rs.getString("REGISTERDATE");
				String sex=rs.getString("SEX");
				String address=rs.getString("ADDRESS");
				String qq=rs.getString("QQ");
				String email=rs.getString("EMAIL");
				String loves=rs.getString("LOVES");
				String birthday=rs.getString("BIRTHDAY");
				Users user=new Users(userid, username, userpass, registerdate, sex, address, qq, email, loves, birthday);
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
}
