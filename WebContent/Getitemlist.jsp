<%@page import="dao.itemListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.json.simple.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String classify = request.getParameter("classify");
	
	String returns="";
	JSONArray arr = new JSONArray();
	itemListDAO dao = itemListDAO.getInstance();
/* 	GetItemListDAO dao = GetItemListDAO.getInstance(); */

	arr = dao.getitemlist(classify);
	
	System.out.println(arr);
	out.println(arr);
%>