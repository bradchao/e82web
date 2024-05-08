<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		key1[2] = ${key1[2] }<br />
		request:key1[2] = ${requestScope.key1[2] }<br />
		session:key1[2] = ${sessionScope.key1[2] }<br />	
		application:key1[2] = ${applicationScope.key1[2] }<br />
		
	</body>
</html>