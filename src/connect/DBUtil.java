package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() {
		Connection con = null;
		
		//String jdbcUrl = "jdbc:oracle:thin:@172.30.1.14:1521:xe";
		String jdbcUrl = "jdbc:oracle:thin:@k-iftshop.cxqwlj3mtyaq.ap-northeast-2.rds.amazonaws.com:1521/ORCL";
	    String userId = ?????????
	    
	    String userPw = ?????????
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(jdbcUrl, userId, userPw);
			System.out.println("db success " + con);
		} catch (Exception e) {
            e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs)
	{
		try
		{
			if(rs!=null)
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
