package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.MyModel;
/*
 * Controller
 */
@WebServlet("/Brad14")
public class Brad14 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1. 接收參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		// 2. 運算
		MyModel myModel = new MyModel(x, y);
		String result = myModel.plus();
		if (x == null && y == null) {
			request.setAttribute("result", "");
			request.setAttribute("x", "");
			request.setAttribute("y", "");			
		}else {
			request.setAttribute("result", result);
			request.setAttribute("x", x);
			request.setAttribute("y", y);
		}
		
		// 3. 呈現 View
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad15");
		dispatcher.forward(request, response);
	}

}