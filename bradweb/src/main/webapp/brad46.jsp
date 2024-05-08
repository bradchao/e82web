<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/iii"
	user="root"
	password="root"
/>
<c:set var="page">${empty param.page?1:param.page }</c:set>
<c:set var="rpp">10</c:set>
<c:set var="start">${(page - 1) * rpp }</c:set>
<sql:query var="rs">
	SELECT * FROM food LIMIT ${start }, ${rpp }
</sql:query>
<c:set var="prev">${page == 1 ? 1 : page - 1 }</c:set>
<c:set var="next">${page + 1 }</c:set>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>美食小吃列表</h1>
		<hr />
		<a href="?page=${prev }">Prev</a> | <a href="?page=${next }">Next</a>
		<hr />
		<table border="1" width="100%">
			<tr>
				<th>#</th>
				<th>id</th>
				<th>名稱</th>
				<th>電話</th>
			</tr>
			
			<c:forEach items="${rs.rows }" var="food" varStatus="status">
				<tr>
					<td>${status.index }</td>
					<td>${food.id }</td>
					<td>${food.name }</td>
					<td>${food.tel }</td>
				</tr>			
			</c:forEach>
			
			
			
			
		</table>	
	</body>
</html>