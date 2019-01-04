package com.resj12.dao;

import java.util.List;

import com.resj12.vo.PrivateMessage;
import com.wsm.db.DBManager;
import com.wsm.mapper.PrivateMessageMapper;

public class PrivateMessageDAO {
	//Ìí¼Ó
	public int addPrivateMessage( PrivateMessage pm) {
		DBManager db=new DBManager();
		String sql="insert into privatemessage values(seq3.nextval,?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'))";
		Object params[]= {pm.getSenderid(),pm.getAccepterid(),pm.getPmcontent(),pm.getPmdate()};
		return db.executeUpdate(sql, params);
		
	}
	//É¾³ı
	public int deletepm(int pmid) {
		DBManager db=new DBManager();
		String sql="delete from privatemessage where pmid=?";
		Object params[]= {pmid};
		return db.executeUpdate(sql, params);
	}
	//²éÑ¯
	public List<PrivateMessage> findById(int id){
		DBManager db=new DBManager();
		Object params[]= {id,id};
		String sql="select * from privatemessage where accepterid=? or senderid=?";
		PrivateMessageMapper mapper=new PrivateMessageMapper();
		List<PrivateMessage> list=db.executeQuery(sql, mapper, params);
		if(list.size()==0) {
			return null;
		}
		return list;
	}
}
