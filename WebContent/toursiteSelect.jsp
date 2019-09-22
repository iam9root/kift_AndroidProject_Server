<%@page import="com.db.PointVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.db.ToursiteDB"%>
<%@page import="dao.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ToursiteDB toursiteDB = ToursiteDB.getInstance();

	
   String email = request.getParameter("email");
	
   ArrayList<PointVO> returns = toursiteDB.connectionDB(email);

   System.out.println("6");
   System.out.println("returns = " + returns);
   
    for(PointVO vo : returns){
	   System.out.println(vo.getTitle()+"/" +vo.getMapx() + "/" + vo.getMapy());
   } 
    System.out.println("7");
   /* 
   for(PointVO vo : list){
	   System.out.println("[" +vo.getTitle()+"/" +vo.getMapx() + "/" + vo.getMapy() +"]");
	   returns += "[" +vo.getTitle()+"/" +vo.getMapx() + "/" + vo.getMapy() +"],";
   }
   
	System.out.println(returns);
    */

   // 안드로이드로 전송
   out.println(returns);
%>