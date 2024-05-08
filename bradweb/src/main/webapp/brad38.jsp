<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer a = (Integer)application.getAttribute("a");
	a++;
	application.setAttribute("a", a);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	a = ${a }
	</body>
</html>