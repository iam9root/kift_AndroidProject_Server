package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.ItemVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import connect.DBUtil;


public class itemListDAO {
	private static itemListDAO instance = new itemListDAO();

    public static itemListDAO getInstance() {
        return instance;
    }
    
    public itemListDAO() {  }

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "";
    String sql2 = "";
    String returns = "a";
    
    //category�뿉 留욌뒗 itemlist
  	public JSONArray getitemlist(String classify) {
  		JSONArray arr = new JSONArray();
  		
  		try {
  			con = DBUtil.getConnection();
  			
  			sql = "select * from itemlist where classify=?"; 	
  			pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, classify);
  			rs = pstmt.executeQuery();

  			while(rs.next()) {
  				ItemVO vo = new ItemVO();
  				vo.setItemid(rs.getString("itemid"));
  				vo.setItemname(rs.getString("itemname"));
  				vo.setPrice(rs.getInt("price"));
  				vo.setThumbnailpath(rs.getString("thumbnailpath"));
  				vo.setImagepath_i(rs.getString("imagepath_i"));
  				vo.setAccessibility(rs.getInt("accessibility"));
  				vo.setStorename(rs.getString("storename"));
  				
  				vo.setC_ten(rs.getInt("c_ten"));
  				vo.setC_twenty(rs.getInt("c_twenty"));
  				vo.setC_thirty(rs.getInt("c_thirty"));
  				vo.setC_forty(rs.getInt("c_forty"));
  				vo.setC_fifty(rs.getInt("c_fifty"));
  				vo.setC_sixty(rs.getInt("c_sixty"));
  				vo.setC_male(rs.getInt("c_male"));
  				vo.setC_female(rs.getInt("c_female"));
  				
  				vo.setClassify(rs.getString("classify"));
  				vo.setHeartcount(rs.getInt("heartcount"));
  				vo.setDestination(rs.getString("destination"));
  				
  				JSONObject obj = new JSONObject();
  				obj.put("itemid", vo.getItemid());
  				obj.put("itemname", vo.getItemname());
  				obj.put("price", vo.getPrice());
  				obj.put("thumbnailpath", vo.getThumbnailpath());
  				obj.put("imagepath_i", vo.getImagepath_i());
  				obj.put("accessibility", vo.getAccessibility());
  				obj.put("storename", vo.getStorename());
  				
  				obj.put("c_ten", vo.getC_ten());
  				obj.put("c_twenty", vo.getC_twenty());
  				obj.put("c_thirty", vo.getC_thirty());
  				obj.put("c_forty", vo.getC_forty());
  				obj.put("c_fifty", vo.getC_fifty());
  				obj.put("c_sixty", vo.getC_sixty());
  				obj.put("c_male", vo.getC_male());
  				obj.put("c_female", vo.getC_female());
  				
  				obj.put("classify", vo.getClassify());
  				obj.put("heartcount", vo.getHeartcount());
  				obj.put("destination", vo.getDestination());
  				
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
  	public JSONArray getitemsearch(String word) {
  		JSONArray arr = new JSONArray();
  		
  		try {
  			con = DBUtil.getConnection();
  			
  			sql = "select * from itemlist where upper(itemname) like upper(?)"; 	

  			pstmt = con.prepareStatement(sql);
  			pstmt.setString(1, word+"%");
  			rs = pstmt.executeQuery();

  			while(rs.next()) {
  				ItemVO vo = new ItemVO();
  				vo.setItemid(rs.getString("itemid"));
  				vo.setItemname(rs.getString("itemname"));
  				vo.setPrice(rs.getInt("price"));
  				vo.setThumbnailpath(rs.getString("thumbnailpath"));
  				vo.setImagepath_i(rs.getString("imagepath_i"));
  				vo.setAccessibility(rs.getInt("accessibility"));
  				vo.setStorename(rs.getString("storename"));
  				
  				vo.setC_ten(rs.getInt("c_ten"));
  				vo.setC_twenty(rs.getInt("c_twenty"));
  				vo.setC_thirty(rs.getInt("c_thirty"));
  				vo.setC_forty(rs.getInt("c_forty"));
  				vo.setC_fifty(rs.getInt("c_fifty"));
  				vo.setC_sixty(rs.getInt("c_sixty"));
  				vo.setC_male(rs.getInt("c_male"));
  				vo.setC_female(rs.getInt("c_female"));
  				
  				vo.setClassify(rs.getString("classify"));
  				vo.setHeartcount(rs.getInt("heartcount"));
  				vo.setDestination(rs.getString("destination"));
  				
  				JSONObject obj = new JSONObject();
  				obj.put("itemid", vo.getItemid());
  				obj.put("itemname", vo.getItemname());
  				obj.put("price", vo.getPrice());
  				obj.put("thumbnailpath", vo.getThumbnailpath());
  				obj.put("imagepath_i", vo.getImagepath_i());
  				obj.put("accessibility", vo.getAccessibility());
  				obj.put("storename", vo.getStorename());
  				
  				obj.put("c_ten", vo.getC_ten());
  				obj.put("c_twenty", vo.getC_twenty());
  				obj.put("c_thirty", vo.getC_thirty());
  				obj.put("c_forty", vo.getC_forty());
  				obj.put("c_fifty", vo.getC_fifty());
  				obj.put("c_sixty", vo.getC_sixty());
  				obj.put("c_male", vo.getC_male());
  				obj.put("c_female", vo.getC_female());
  				
  				obj.put("classify", vo.getClassify());
  				obj.put("heartcount", vo.getHeartcount());
  				obj.put("destination", vo.getDestination());
  				
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

