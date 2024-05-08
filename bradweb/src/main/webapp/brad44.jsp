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
<c:choose>
	<c:when test="${!empty param.key }">
		<sql:query var="rs">
			SELECT * FROM food WHERE name LIKE '%${param.key }%' 
		</sql:query>	
	</c:when>
	<c:otherwise>
		<sql:query var="rs">
			SELECT * FROM food
		</sql:query>	
	</c:otherwise>
</c:choose>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>美食小吃列表</h1>
		<hr />
		${rs.rowCount }<br />
		<c:forEach items="${rs.columnNames }" var="column">
			${column }<br />
		</c:forEach>
		<hr />
		
		<form>
			Keyword: <input name="key" value="${param.key }"/>
			<input type="submit" value="Serach" />
		</form>
		
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