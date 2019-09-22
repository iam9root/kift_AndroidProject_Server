<%@page import="org.json.simple.JSONArray"%>
<%@page import="vo.MyListVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MyListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//user email
	//String email = request.getParameter("email");
	// DB Connection Setting
	request.setCharacterEncoding("UTF-8");
	String dbdriver = "oracle.jdbc.driver.OracleDriver";
	//String dburl = "jdbc:oracle:thin:@172.30.1.9:1521:xe";
	String dburl = "jdbc:oracle:thin:@k-iftshop.cxqwlj3mtyaq.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
	
	String dbid = "kift";
	//String dbpw = "kift";
	String dbpw = "kift#568974";

	MyListDAO mldao = new MyListDAO(dbdriver, dburl, dbid, dbpw);
	JSONArray jsonarr = mldao.getItemlist();  
	
	out.print(jsonarr);
	
%>
