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
		int result = 0;
		String op = "";
		
		if (request.getParameter("x") != null) {
			x = request.getParameter("x");
			y = request.getParameter("y");
			op = request.getParameter("op");
			switch (op) {
				case "1":
					result = Integer.parseInt(x) + Integer.parseInt(y);
					span = String.format("<span>%s</span>", result+"");
					break;
				case "2":
					result = Integer.parseInt(x) - Integer.parseInt(y);
					span = String.format("<span>%s</span>", result+"");
					break;
				case "3":
					result = Integer.parseInt(x) * Integer.parseInt(y);
					span = String.format("<span>%s</span>", result+"");
					break;
				case "4":
					result = Integer.parseInt(x) / Integer.parseInt(y);
					int mod = Integer.parseInt(x) % Integer.parseInt(y);
					span = String.format("<span>%s</span>", result+ " ... " + mod);
					break;
			}
			
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<meta charset='UTF-8'>")
			.append("<form>")
			.append(String.format("<input name='x' value='%s' />", x))
			.append(" <select name='op'>")
			.append(String.format("<option value='1' %s>+</option>", op.equals("1")?"selected":""))
			.append(String.format("<option value='2' %s>-</option>", op.equals("2")?"selected":""))
			.append(String.format("<option value='3' %s>x</option>", op.equals("3")?"selected":""))
			.append(String.format("<option value='4' %s>/</option>", op.equals("4")?"selected":""))
			.append("</select> ")
			.append(String.format("<input name='y' value='%s' />", y))
			.append("<input type='submit' value='='>")
			.append(span)
			.append("</form>");
		response.flushBuffer();
		
	}

}
