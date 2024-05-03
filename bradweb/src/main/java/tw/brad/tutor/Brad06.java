package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad06")
public class Brad06 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String span = "", x = "", y = "";
		
		if (request.getParameter("x") != null) {
			x = request.getParameter("x");
			y = request.getParameter("y");
			int result = Integer.parseInt(x) + Integer.parseInt(y);
			
			span = String.format("<span>%s</span>", result+"");
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<meta charset='UTF-8'>")
			.append("<form>")
			.append(String.format("<input name='x' value='%s' />", x))
			.append(" <select>")
			.append("<option>+</option>")
			.append("<option>-</option>")
			.append("<option>x</option>")
			.append("<option>/</option>")
			.append("</select> ")
			.append(String.format("<input name='y' value='%s' />", y))
			.append("<input type='submit' value='='>")
			.append(span)
			.append("</form>");
		response.flushBuffer();
		
	}

}
