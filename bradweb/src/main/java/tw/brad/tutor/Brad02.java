package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad02")
public class Brad02 extends HttpServlet {
	public Brad02() {
		System.out.println("Brad02()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.getWriter().append("V3Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		pw.append("Hello, World");
		System.out.println("OK");
	}
}
