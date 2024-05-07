<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	int r = Integer.parseInt(x) + Integer.parseInt(y); 
	out.print(String.format("%s + %s = %d", x, y, r));
%>