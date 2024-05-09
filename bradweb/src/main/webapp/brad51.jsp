<%@page import="tw.brad.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer a = (Integer)session.getAttribute("a");
	int[] b = (int[])session.getAttribute("b");
	Bike bike = (Bike)session.getAttribute("bike");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	a = <%= a %><br />
	b[2] = <%= b[2] %><br />
	<%= bike %>
	</body>
</html>