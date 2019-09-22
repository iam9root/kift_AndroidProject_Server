package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.ItemVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import connect.DBUtil;


public class heartCheckDAO {
	private static heartCheckDAO instance = new heartCheckDAO();

    public static heartCheckDAO getInstance() {
        return instance;
    }
    
    public heartCheckDAO() {  }

    Connection con = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    
    String sql = "";
    String sql2 = "";
    
    String returns = "a";
    
    //category�뿉 留욌뒗 itemlist
  	public JSONArray heartCheck(String email, String itemid) {
  		JSONArray arr = new JSONArray();
  		
  		try {
  			con = DBUtil.getConnection();
  			
  			//select count(*) from mylist where email='admin@naver.com' and itemid='HV10';
  			
  			//sql = "select * from itemlist where classify=?"; 	
  			sql = "select count(*) from mylist where email=? and itemid=?";
  			pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, email);
  			pstmt.setString(2, itemid);
  			rs = pstmt.executeQuery();

  			while(rs.next()) {
  				
  				ItemVO vo = new ItemVO();
  				
  				int count = rs.getInt(1);
  				System.out.println(count);  				
  				
  				JSONObject obj = new JSONObject();
  				
  				if (count>=1) {
  					obj.put("count", count);
  				}
  				else {
  					obj.put("count", 0);
  				}
  				
  				if(obj != null) {
  					arr.add(obj);
  				}
  			} 		
  		} catch(Exception e) {
  			e.printStackTrace();
  		} finally {
  			DBUtil.close(con,pstmt);
  		}
  		return arr;
  	}
  	
  	// 추가 
  	public JSONArray heartInsert(String email, String itemid, String birth, String gender) {
  		JSONArray arr = new JSONArray();
  		
  		try {
  			con = DBUtil.getConnection();
  			
  			//select count(*) from mylist where email='admin@naver.com' and itemid='HV10';
  			
  			//sql = "select * from itemlist where classify=?"; 	
  			sql = "insert into mylist values(mylist_seq.nextval, ?, ?, 1, 0)";
  			
   			pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, email);
  			pstmt.setString(2, itemid);
  			rs = pstmt.executeQuery();
  			
  			
  			sql2 = "update itemlist set ?=?+1, ?=?+1 where itemid=?";
  			
   			pstmt2 = con.prepareStatement(sql2);
  			pstmt2.setString(1, birth);
  			pstmt2.setString(2, birth);
  			pstmt2.setString(3, gender);
  			pstmt2.setString(4, gender);
  			pstmt2.setString(5, itemid);
  			System.out.println(pstmt2);
  			rs2 = pstmt2.executeQuery();

  			if(rs2.next()) {
  				System.out.println(rs2.next());
  			}
  			while(rs.next()) {
  				System.out.println(rs.getString("count(*)"));
  				ItemVO vo = new ItemVO();
  				
  				vo.setItemid(rs.getString("email"));
  				vo.setItemid(rs.getString("itemid"));
  				
  				
  				JSONObject obj = new JSONObject();
  				
  				obj.put("email", vo.getEmail());
  				obj.put("itemid", vo.getItemid());
  				
  				if(obj != null) {
  					arr.add(obj);
  				}
  			} 		
  		} catch(Exception e) {
  			e.printStackTrace();
  		} finally {
  			DBUtil.close(con,pstmt);
  		}
  		return arr;
  	}
  	
  	
  //word�뿉 留욌뒗 itemlist
  	public JSONArray heartDelete(String email, String itemid) {
  		JSONArray arr = new JSONArray();
  		
  		try {
  			con = DBUtil.getConnection();
  			
  			//select count(*) from mylist where email='admin@naver.com' and itemid='HV10';
  			
  			//sql = "select * from itemlist where classify=?"; 	
  			sql = "select count(*) from mylist where email=? and itemid=?";
  			pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, email);
  			pstmt.setString(2, itemid);
  			rs = pstmt.executeQuery();

  			while(rs.next()) {
  				System.out.println(rs.getString("count(*)"));
  				ItemVO vo = new ItemVO();
  				vo.setItemid(rs.getString("type"));
  				vo.setItemid(rs.getString("email"));
  				vo.setItemid(rs.getString("itemid"));
  				
  				
  				JSONObject obj = new JSONObject();
  				obj.put("type", vo.getType());
  				obj.put("email", vo.getEmail());
  				obj.put("itemid", vo.getItemid());
  				
  				if(obj != null) {
  					arr.add(obj);
  				}
  			} 		
  		} catch(Exception e) {
  			e.printStackTrace();
  		} finally {
  			DBUtil.close(con,pstmt);
  		}
  		return arr;
  	}
}

