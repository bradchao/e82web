<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mesg = "";
	String errType = request.getParameter("errType");
	if (errType != null){
		if (errType.equals("1")){
			mesg = "Insert Failure";
		}else if (errType.equals("2")){
			mesg = "Account is EXIST";
		}
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div><%= mesg %></div>
		<form action="Register" method="post">
			Account: <input name="account" /><br />
			Password: <input type="password" name="passwd" /><br />
			Realname: <input name="realname" /><br />
			<input type="submit" value="Register">
		</form>
	</body>
</html>