<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] name1 = {"Brad","Mark","Peter", "Kevin"};
	//pageContext.setAttribute("name1", name1);

	String[] name2 = {"Brad2","Mark2","Peter2", "Kevin2"};
	request.setAttribute("name1", name2);

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		name1[2] = ${name1[2] }<br />
		request:name1[2] = ${requestScope.name1[2] }<br />
	</body>
</html>