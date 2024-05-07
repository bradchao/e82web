package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.MemberDB;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private MemberDB memberDB;
	
	public Register() {
		try {
			memberDB = new MemberDB();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String realname = request.getParameter("realname");
		
		try {
			if (!memberDB.isAccountExist(account)) {
				if (memberDB.addNew(account, passwd, realname)>0) {
					response.sendRedirect("brad24.jsp");
				}else {
					response.sendRedirect("brad23.jsp?errType=1");
				}
			}else {
				response.sendRedirect("brad23.jsp?errType=2");
			}
		}catch(Exception e) {
			response.sendError(500, "Server Busy");
		}
		

	}
	
	

}