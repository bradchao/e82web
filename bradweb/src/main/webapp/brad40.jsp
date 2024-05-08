<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="brad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<brad:catch var="error">
	<%
		String n = request.getParameter("n");
		int num = Integer.parseInt(n);
		out.print(n);
	%>
	</brad:catch>
	Hello, OK
	<hr />
	${error }
	
	</body>
</html>