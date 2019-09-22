package dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class GetLoginDB {
	private static GetLoginDB instance = new GetLoginDB();

    public static GetLoginDB getInstance() {
        return instance;
    }
    
    public GetLoginDB() {  }

    // oracle Í≥ÑÏ†ï
    String jdbcUrl = "jdbc:oracle:thin:@172.16.6.39:1521:xe";
    String jdbcId = "kift";
    String jdbcPw = "kift";
    String dbpw = "";

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "";
    String sql2 = "";
    String returns = "a";

    public String connectionDB(String id, String pwd) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPw);

            sql = "select pw from member where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            

            rs = pstmt.executeQuery();
            System.out.println("1");
            if (rs.next()) {
            	System.out.println("2");
            	System.out.println("userPw = " + pwd);
            	dbpw = rs.getString("pw");
            	System.out.println("dbpw = " + dbpw);
            	System.out.println("userPw =" + pwd);
            	if(dbpw.equals(pwd)) {
            		System.out.println("3");
            		returns = "Success";
            	}
//                returns = "?ù¥ÎØ? Ï°¥Ïû¨?ïò?äî ?ïÑ?ù¥?îî ?ûÖ?ãà?ã§.";
            } else {
            	System.out.println("4");
                returns = "Fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("5");
        } finally {
        	System.out.println("6");
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (con != null)try {con.close();    } catch (SQLException ex) {}
        }
        System.out.println("7");
        return returns;
    }
}
