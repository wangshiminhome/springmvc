package com.wsm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.resj12.vo.Messages;

public class MessagesMapper implements IMapper {

	@Override
	public List<Messages> map(ResultSet rs) {
		List<Messages> list=new ArrayList<>();
		try {
			while(rs.next()) {
				int mid=rs.getInt("MID");
				int userid=rs.getInt("USERID");
				String mcontend=rs.getString("MCONTEND");
				String mdate=rs.getString("MDATE");
				Messages m=new Messages(mid, userid, mcontend, mdate);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
