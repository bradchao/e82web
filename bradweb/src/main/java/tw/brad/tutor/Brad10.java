package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad10")
public class Brad10 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad11");
		
		request.setAttribute("range", 100);
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>Brad Big Company</h1>");
		out.print("<hr />");
		out.print("<div>Hello, World</div>");
		dispatcher.include(request, response);
		out.print("<hr />");
		
		response.flushBuffer();
	}

}
