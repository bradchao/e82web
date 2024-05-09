<%@page import="tw.brad.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int a = 10;
	session.setAttribute("a", a);
	a++;
	int[] b = {1,2,3,4};
	session.setAttribute("b", b);
	b[2] = 33;
	
	Bike bike = new Bike();
	session.setAttribute("bike", bike);
	bike.upSpeed(); bike.upSpeed();bike.upSpeed();
	bike.upSpeed();bike.upSpeed();bike.upSpeed();
	
	session.setMaxInactiveInterval(10);
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	a1 = <%= a %><br />
	a2 = ${a }<br />
	<hr />
	b[2] = <%= b[2] %><br />
	${b[2] }<br />
	<hr />
	<%= bike %><br />
	${bike }<br />
	<a href="brad51.jsp">brad51</a> 
	</body>
</html>