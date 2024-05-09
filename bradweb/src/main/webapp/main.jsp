<%@page import="tw.brad.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("member") == null){
		response.sendRedirect("login.jsp");
		return;
	}
	
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Main Page
	<hr />
	Welcome, ${member.realname }
	<hr />
	<a href="logout.jsp">Logout</a>
	</body>
</html>