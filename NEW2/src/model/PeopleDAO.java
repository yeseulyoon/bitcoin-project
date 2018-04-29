package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.PeopleDTO;
import util.DBUtil1;

public class PeopleDAO {
	
	//?��?���??��?��?��?�� DB?�� 추�?
	public static int insert(PeopleDTO value) throws SQLException{
		System.out.println("---- insert ----");
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil1.getConnection();
			pstmt = con.prepareStatement("insert into people values(?,?,?,?,?)");
			
			pstmt.setString(1, value.getId());
			pstmt.setString(2, value.getPw());
			pstmt.setString(3, value.getName());
			pstmt.setString(4, value.getGender());
			pstmt.setString(5, value.getBirthday());
			
			System.out.println("----- - 7 ");
			return pstmt.executeUpdate();
			
		}finally {
			DBUtil1.close(con, pstmt);
		}
	}
	
	//로그?�� �??��
	public static int login(String id, String pw){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try{
			con = DBUtil1.getConnection();
			pstmt = con.prepareStatement("select password from people where id =?");
			
			pstmt.setString(1, id);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				if(rset.getString(1).equals(pw)) {
					return 1;
				}
				return 0;
			}
			return -1;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil1.close(con, pstmt);
		}return -2;
	}
	
	//?��?���??�� 중복 ?��?��?�� 체크
	/* ?���? 존재?��?��  id ?�� 경우 : 1 반환
	 * �? 존재?�� 경우 : -1 반환  */
	public static int joinCheck(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try{
			con = DBUtil1.getConnection();
			pstmt = con.prepareStatement("select id from people where id=?");
			pstmt.setString(1, id);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				return 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil1.close(con, pstmt);
		}
		return -1;
	}
		
   //모든 ?��?��?���? �??��
   public static ArrayList<PeopleDTO> selectAllPeople() throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<PeopleDTO>all=null;
      try {
         con=DBUtil1.getConnection();
         pstmt=con.prepareStatement("select * from people");
         rset=pstmt.executeQuery();
         
         all=new ArrayList<PeopleDTO>();
         
         while (rset.next()) {
        	 all.add(new PeopleDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5)));
         }
      }finally {
         DBUtil1.close(con, pstmt, rset);
      }
      return all;
   }
   
   //강제추방(?��?��?���? ?��?��)
   public static boolean deletePerson(String id) throws SQLException {
      Connection con = null;
      PreparedStatement pstmt = null;
      try {
         con = DBUtil1.getConnection();
         pstmt = con.prepareStatement("delete from people where id=?");
         pstmt.setString(1, id);
         int result = pstmt.executeUpdate();
         if(result==1) {
            return true;
         }
      }finally {
         DBUtil1.close(con, pstmt);
      }
      return false;
   }
}
