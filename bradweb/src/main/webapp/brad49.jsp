<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.brad.apis.*" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvMovingRoad.aspx" var="data"></c:import>    
<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/iii"
	user="root"
	password="root"
/>
<c:set var="travel">${BradUtils.parseTravel(data) }</c:set>
<c:forEach items="${travel }" var="item">
	<sql:update>
		INSERT INTO travel (name,city,town) VALUES (?,?,?)
		<sql:param></sql:param>
		<sql:param></sql:param>
		<sql:param></sql:param>
	</sql:update>
</c:forEach>