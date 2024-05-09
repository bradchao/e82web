<%@page import="tw.brad.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<%
	if (session.getAttribute("member") == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>    

<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/iii"
	user="root"
	password="root"
/>

<c:if test="${! empty param.delid }">
	<sql:update>
		DELETE FROM travel WHERE id = ?
		<sql:param>${param.delid }</sql:param>
	</sql:update>
</c:if>


<sql:query var="rs">
	SELECT * FROM travel
</sql:query>
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
	<hr />
	<table border="1" width="100%">
		<c:forEach items="${rs.rows }" var="travel">
			<tr>
				<td>${travel.id }</td>
				<td>${travel.name }</td>
				<td>${travel.city }</td>
				<td>${travel.town }</td>
				<td><a href="?delid=${travel.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	</body>
</html>