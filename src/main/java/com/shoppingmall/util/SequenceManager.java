package com.shoppingmall.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//시퀀스번호를 가져오기 위한 클래스
public class SequenceManager {
	public synchronized static int nextId(Connection conn, String tableName)throws SQLException{
		//synchronized= 동기화목적 : 동시에 여러사람이 사용을 할 때 접근한 사람들에게 순번을 주어 한사람이 끝나고 다음사람이 접근하도록 해줌
		PreparedStatement pstmtSelect = null, pstmtUpdate = null;
		ResultSet rs = null;
		int returnValue;
		pstmtSelect = conn.prepareStatement("select sequence_no from sequence where table_name = ?");
		pstmtSelect.setString(1, tableName);
		rs = pstmtSelect.executeQuery(); //최대글번호가 rs에 들어감
		try{
			if(rs.next()){ //검색결과가 있는경우
				int id = rs.getInt(1); id++; //select한 첫번째 값 = 최대글번호.& 1증가
				pstmtUpdate = conn.prepareStatement("update sequence set sequence_no = ? where table_name = ?"); 
					//가져온 마지막 번호를 1을 증가시켜서 LAST_ID에 다시 넣어줌(set)
				pstmtUpdate.setInt(1, id);
				pstmtUpdate.setString(2, tableName);
				pstmtUpdate.executeUpdate();
				return id;
			}else {//검색결과가 없는경우
				pstmtUpdate = conn.prepareStatement("insert into sequence values(?,?)");
				pstmtUpdate.setInt(1, 1);
				pstmtUpdate.setString(2, tableName);

				pstmtUpdate.executeUpdate();
				return 1;
			}
		}catch(Exception e){
			throw new SQLException(e);
		}finally{
			try{pstmtUpdate.close(); pstmtSelect.close(); rs.close();}catch(Exception e){}
		}
	}

}
