package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBUtil;
import vo.PointVO;

public class tourSiteDAO {
	private static tourSiteDAO instance = new tourSiteDAO();

    public static tourSiteDAO getInstance() {
        return instance;
    }
    public tourSiteDAO() {  }

    // oracle 계정
//    String jdbcUrl = "jdbc:oracle:thin:@192.168.30.112:1521:xe";
    Connection con = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    String sql = "";
//    String sql2 = "";
    String returns = "a";
    ArrayList<PointVO> list = new ArrayList<PointVO>();

    public ArrayList<PointVO> connectionDB(String email) {
        try {
        	System.out.println("1");
            
            con = DBUtil.getConnection();

            sql = "select title, mapx, mapy from mysite m, toursite t where m.toursiteid=t.toursiteid and email=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            System.out.println("2");
            

            rs = pstmt.executeQuery();
            System.out.println("4");
            while (rs.next()) {
                PointVO vo = new PointVO();
            	vo.setTitle(rs.getString("title"));
            	vo.setMapx(rs.getString("mapx")); 
            	vo.setMapy(rs.getString("mapy")); 
            	System.out.println(vo);
            	list.add(vo);
            }
        } catch (Exception e) {
        	System.out.println("error1");
            e.printStackTrace();
        } finally {
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (con != null)try {con.close();    } catch (SQLException ex) {}
        }
        System.out.println("list : " + list);
        System.out.println("5");
        return list;
    }
}
