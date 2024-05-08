<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] name1 = {"Brad","Mark","Peter", "Kevin"};
	pageContext.setAttribute("key1", name1);

	String[] name2 = {"Brad2","Mark2","Peter2", "Kevin2"};
	request.setAttribute("key1", name2);

	String[] name3 = {"Brad3","Mark3","Peter3", "Kevin3"};
	session.setAttribute("key1", name3);

	String[] name4 = {"Brad4","Mark4","Peter4", "Kevin4"};
	application.setAttribute("key1", name4);
	
	
%>

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