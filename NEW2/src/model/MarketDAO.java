package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import model.domain.MarketDTO;
import util.DBUtil;

public class MarketDAO {
	public static ArrayList<String> getMarketNames() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<String> list = null;
		String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'mysql' and TABLE_NAME like 'market_%'";
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
	
public static HashMap<String, MarketDTO> getMarketAll(String market) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from market_" + market.trim() ;

		HashMap<String, MarketDTO> Data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			Data = new HashMap<String, MarketDTO>();
			while (rset.next()) {
				Data.put(rset.getString("index_no"), new MarketDTO(rset.getInt("index_no"), rset.getString("coin"), rset.getString("pairs"), rset.getString("prices"), rset.getString("volumes")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return Data;
	}
	
}
