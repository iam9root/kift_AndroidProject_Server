package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }
    public ConnectDB() {  }

    // oracle Í≥ÑÏ†ï
    String jdbcUrl = "jdbc:oracle:thin:@172.16.6.39:1521:xe";
    String userId = "kift";
    String userPw = "kift";

    Connection con = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    String sql = "";
    String sql2 = "";
    String returns = "a";

    public String connectionDB(String id, String pwd) {
        try {
        	System.out.println("2");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(jdbcUrl, userId, userPw);

            sql = "select id from member where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            System.out.println("1");
            

            rs = pstmt.executeQuery();
            if (rs.next()) {
                returns = "?ù¥ÎØ? Ï°¥Ïû¨?ïò?äî ?ïÑ?ù¥?îî ?ûÖ?ãà?ã§.";
            } else {
                sql2 = "INSERT INTO member VALUES(?,?)";
                pstmt2 = con.prepareStatement(sql2);
                pstmt2.setString(1, id);
                pstmt2.setString(2, pwd);
                pstmt2.executeUpdate();
                returns = "?öå?õê Í∞??ûÖ ?Ñ±Í≥? !";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (con != null)try {con.close();    } catch (SQLException ex) {    }
        }
        return returns;
    }
}
