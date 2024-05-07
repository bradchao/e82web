package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad18")
public class Brad18 extends HttpServlet {
	private Connection conn;
	
	public Brad18() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii?user=root&password=root");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<table border='1'>");
		out.print("<tr><th>Name</th><th>Tel</th></tr>");
		
		String key = request.getParameter("key");
		String sql = "SELECT * FROM food WHERE name LIKE ?";
		if (key == null) {
			sql = "SELECT * FROM food";
		}
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (key != null) pstmt.setString(1, "%" + key + "%");
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				out.print("<tr>");
				out.print(String.format("<td>%s</td>",rs.getString("name")));
				out.print(String.format("<td>%s</td>",rs.getString("tel")));
				out.print("</tr>");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		out.print("</table>");
		
		
		
		


		response.flushBuffer();
	}

}