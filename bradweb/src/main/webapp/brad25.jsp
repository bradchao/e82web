<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<h1>Brad Big Company</h1>
	<hr />
	<jsp:include page="brad26.jsp">
		<jsp:param value="10" name="x"/>
		<jsp:param value="3" name="y"/>
	</jsp:include>
	<hr />
	</body>
</html>