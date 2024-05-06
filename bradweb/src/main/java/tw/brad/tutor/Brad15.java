package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.BradUtils;

@WebServlet("/Brad15")
public class Brad15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result = (String)request.getAttribute("result");
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String webPage = "NOT FOUND";
		try {
			webPage = BradUtils.loadView("viewv2");
		}catch(Exception e) {}
		
		out.printf(webPage, x, y, result);
		

		response.flushBuffer();
	}

}