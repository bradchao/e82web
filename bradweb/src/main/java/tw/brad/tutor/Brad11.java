package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad11")
public class Brad11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String min = request.getParameter("min");
		int range = (Integer)request.getAttribute("range");
		
		
		try {
			int minValue = Integer.parseInt(min);
			response.getWriter().print((int)(Math.random()*range+minValue));
		}catch(Exception e) {
			response.getWriter().print("Ooop!");
		}
	}

}