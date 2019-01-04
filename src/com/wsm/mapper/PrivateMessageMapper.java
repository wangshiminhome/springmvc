package com.wsm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.resj12.vo.PrivateMessage;


public class PrivateMessageMapper implements IMapper {

	@Override
	public List<PrivateMessage> map(ResultSet rs) {
		List<PrivateMessage> list=new ArrayList<>();
		try {
			while(rs.next()) {
				int mid=rs.getInt("PMID");
				int senderid=rs.getInt("SENDERID");
				int accepterid=rs.getInt("ACCEPTERID");
				String pmcontent=rs.getString("PMCONTENT");
				String pmdate=rs.getString("PMDATE");
				PrivateMessage pm=new PrivateMessage(mid, senderid, accepterid, pmcontent, pmdate);
				list.add(pm);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
