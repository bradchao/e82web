<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="tw.brad.apis.Member"></jsp:useBean>
<jsp:setProperty property="account" value="${param.account }" name="member" />
<jsp:setProperty property="realname" value="${param.realname }" name="member" />    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member1 :
		<jsp:getProperty property="account" name="member" /> :
		<jsp:getProperty property="realname" name="member" /> <hr />
		Member1 : ${member.account } : ${member.realname }
		<hr />
		${member }<br />
		${Math.random() }
	</body>
</html>