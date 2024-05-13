<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	out.print(String.format("%s : %s", request.getParameter("account"), request.getParameter("passwd")));
%>