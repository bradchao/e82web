<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<!DOCTYPE html>
<html>
	<sql:setDataSource 
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>
	<!--  here  -->
	<sql:update>
	INSERT INTO cust (cname,tel,birthday) VALUES ('${param.cname }','123','1999-01-02')
	</sql:update>
	<sql:update>
	UPDATE cust SET cname = 'bbb' WHERE id = 16
	</sql:update>
	<sql:update>
	DELETE FROM cust WHERE id = 15
	</sql:update>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
	</body>
</html>