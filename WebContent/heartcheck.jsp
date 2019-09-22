<%@page import="dao.heartCheckDAO"%>
<%@page import="vo.ItemVO"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	String email = request.getParameter("email");
	String itemid = request.getParameter("itemid");
	
	/* 논의 해야 할 부분  나이대와 성별 또한 가져와야 하는데 변수는 무엇  */
	int birth2 = Integer.parseInt(request.getParameter("birth"));
	String birth = "";
	
	switch(birth2){
		case 1:
			birth="c_ten";
		break;
		case 2:
			birth="c_twenty";
		break;
		case 3:
			birth="c_thirty";
		break;
		case 4:
			birth="c_forty";
		break;
		case 5:
			birth="c_fifty";
		break;
		case 6:
			birth="c_sixty";
		break;
	}
	
	String gender = request.getParameter("gender");
	switch(gender){
		case "1":
			gender = "c_male";
		break;
		case "2":
			gender = "c_female";
		break;
	}
	
	/* 논의 해야 할 부분  나이대와 성별 또한 가져와야 하는데 변수는 무엇  */
	
	JSONArray arr = new JSONArray();
	heartCheckDAO dao = heartCheckDAO.getInstance();
	
	if (type.equals("check")){
		arr = dao.heartCheck(email, itemid);
		System.out.println(arr);
		out.println(arr);
	}
	else if(type.equals("insert")){
		arr = dao.heartInsert(email, itemid, birth, gender);
		System.out.println(arr);
		out.println(arr);
	}
	else if (type.equals("delete")){
		arr = dao.heartDelete(email, itemid);
		System.out.println(arr);
		out.println(arr);
	}
	else{
		System.out.println("type 오류");
		out.println("type 오류");
	}
	
%>