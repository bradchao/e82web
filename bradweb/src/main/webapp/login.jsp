<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<%@ page import="tw.brad.apis.*" %>
<c:if test="${! empty param.account }">
	<sql:setDataSource 
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>
	<sql:query var="rs">
		SELECT * FROM member WHERE account = ?
		<sql:param>${param.account }</sql:param>
	</sql:query>
	<c:choose>
		<c:when test="${rs.rowCount > 0 }">
			<c:set var="hashPasswd" value="${rs.rows[0].passwd }" />
			<c:choose>
				<c:when test="${BCrypt.checkpw(param.passwd, hashPasswd) }">
					<jsp:useBean id="member0" class="tw.brad.apis.Member"></jsp:useBean>
					<c:set target="${member0 }" property="id">${rs.rows[0].id }</c:set>
					<c:set target="${member0 }" property="account">${rs.rows[0].account }</c:set>
					<c:set target="${member0 }" property="passwd">${rs.rows[0].passwd }</c:set>
					<c:set target="${member0 }" property="realname">${rs.rows[0].realname }</c:set>
					<c:set var="member" value="${member0 }" scope="session" />
					<c:redirect url="main.jsp"></c:redirect>
				</c:when>
				<c:otherwise>
					<c:set var="mesg" value="Login Failure(2)" />
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:set var="mesg" value="Login Failure(1)" />
		</c:otherwise>
	</c:choose>
</c:if>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Login Page
	<hr />
	${mesg }
	<form method="post">
		Account: <input name="account" /><br />
		Password: <input type="password" name="passwd" /><br />
		<input type="submit" value="Login" />
	</form>
	
	
	</body>
</html>