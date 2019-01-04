package com.wsm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wsm.mapper.IMapper;

//import com.wsm.mapper.StudentDateMapper;


public class DBManager {
	private Connection getconn() throws SQLException{
		Connection conn=DBHelper.cpds.getConnection();
		return conn;
	}
	
	public int executeUpdate(String sql,Object params[]){
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=getconn();
			pst=conn.prepareStatement(sql);
			if(params !=null){
				for(int i=0;i<params.length;i++){
					pst.setObject(i+1,params[i]);
				}
			}
			int i=pst.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return -1;
	}
	public List executeQuery(String sql,IMapper mapper,Object params[]){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List list=new ArrayList();
		try {
			conn=getconn();
			pst=conn.prepareStatement(sql);
			if(params !=null){
				for(int i=0;i<params.length;i++){
					pst.setObject(i+1,params[i]);
				}
			}
			rs=pst.executeQuery();
			list=mapper.map(rs);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
}
