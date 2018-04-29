package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import model.domain.TablesDTO;
import util.DBUtil;

public class TablesDAO {
	
	public static ArrayList<String> getTablesNames() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<String> list = null;
		String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'mysql' and TABLE_NAME like 'crypto_%'";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<String>();
			while (rset.next()) {
				list.add(rset.getString("table_name"));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static HashMap<String, TablesDTO> getTableAll(String cryptoCurrBitcoin) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from crypto_curr_" + cryptoCurrBitcoin.trim() ;

		HashMap<String, TablesDTO> allData = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			allData = new HashMap<String, TablesDTO>();
			while (rset.next()) {
				allData.put(rset.getString("index_no"), new TablesDTO(rset.getInt("index_no"), rset.getString("close"), rset.getString("date"),
																						rset.getString("high"), rset.getString("low"), rset.getString("open"), rset.getString("volume")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return allData;
	}

}
