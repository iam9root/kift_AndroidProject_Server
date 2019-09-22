package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MyListDAO {
	String driver, url, account, dbpw;
	//MyListVO mlvo = null;
	//ArrayList<MyListVO> arr_mylist = null;
	JSONArray jsonarr = null;
	
	public MyListDAO(String driver, String url, String account, String dbpw) {
		this.driver = driver;
		this.url = url;
		this.account = account;
		this.dbpw = dbpw;
	}

	@SuppressWarnings("unchecked")
	public JSONArray getItemlist() {
		try {
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, account, dbpw);

			String sql = "select i.itemname, m.count, i.price from itemlist i, mylist m where i.itemid = m.itemid";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			jsonarr = new JSONArray();

			while(rs.next()) {
				JSONObject jsonobj = new JSONObject();
				
				// Í∏∞ÎÖê?íàÎ™? | ?àò?üâ | Í∞?Í≤?
				jsonobj.put("itemname", rs.getString("itemname"));
				jsonobj.put("count", rs.getInt("count"));
				jsonobj.put("price", rs.getInt("price"));
				
				if (jsonobj != null)
					jsonarr.add(jsonobj);
			}
			
			//out.print(jsonarr);

			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return jsonarr;
	}


}
