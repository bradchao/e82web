<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//out.print(request.getMethod());
	//String[] hobby = request.getParameterValues("hobby");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Method: ${pageContext.request.method }<br />
		1. ${paramValues.hobby[0] }<br />
		2. ${paramValues.hobby[1] }<br />
		3. ${paramValues.hobby[2] }<br />
		4. ${paramValues.hobby[3] }<br />
		5. ${paramValues.hobby[4] }<br />
		6. ${paramValues.hobby[5] }<br />
		${pageContext.request.remoteAddr }<br />
		${pageContext.request.locale }<br />
		${pageContext.request.locale.displayLanguage }:<%= request.getLocale().getDisplayLanguage() %> <br />
		
		
		
	</body>
</html>