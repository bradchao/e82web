<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="brad21.jsp" %>
<%
	String name = request.getParameter("name");
	name.charAt(0);
	if (name == null) name = "World"; 
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		Hello, <% out.print(name); %><br />
		Hello, <%= name %><br />
		Lottery: <%= (int)(Math.random()*49+1) %><br />
		<hr />
		<%
			HashSet<Integer> set = new HashSet<>();
			while (set.size() < 6) set.add((int)(Math.random()*49+1));
			out.print(set);
		%>
	</body>
</html>