<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.itemListDAO" %>
<%@ page import="java.util.List"%>
<%@ page import="org.json.simple.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String word = request.getParameter("word");
	
	String returns="";
	JSONArray arr = new JSONArray();

	itemListDAO dao = itemListDAO.getInstance();
	arr = dao.getitemsearch(word);
	
	System.out.println(arr);
	out.println(arr);
%>