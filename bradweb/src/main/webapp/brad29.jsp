<%@page import="tw.brad.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member1 = new Member();
	member1.setId(1); member1.setAccount("brad");member1.setRealname("Brad");
%>
<jsp:useBean id="member2" class="tw.brad.apis.Member"></jsp:useBean>
<jsp:setProperty property="id" value="2" name="member2" />
<jsp:setProperty property="account" value="amy" name="member2" />
<jsp:setProperty property="realname" value="Amy" name="member2" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member1 : <%= member1.getId() %> : <%= member1.getAccount() %> : <%= member1.getRealname() %><br />
		Member2 : <jsp:getProperty property="id" name="member2" /> :
		<jsp:getProperty property="account" name="member2" /> :
		<jsp:getProperty property="realname" name="member2" /> <br />
		Member2 : <%= member2.getId() %> : <%= member2.getAccount() %> : <%= member2.getRealname() %><br />
		
	
	</body>
</html>