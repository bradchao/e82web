package tw.brad.tutor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad08")
@MultipartConfig(
		location = "C:\\Users\\User\\git\\repository2\\bradweb\\src\\main\\webapp\\upload"
		)
public class Brad08 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Part part = null;
		try {
			part = request.getPart("upload");
			System.out.println(part.getName());
			System.out.println(part.getSize());
			System.out.println(part.getSubmittedFileName());
			System.out.println(part.getContentType());
			if (part.getSize() > 0) {
				part.write(part.getSubmittedFileName());
				System.out.println("OK");
			}
		}catch(Exception e) {
			System.out.println(e);
			String ip = request.getRemoteHost();
			System.out.println(ip);
			if (part != null) {
				System.out.println(part.getName());
			}
		}
		
		
	}

}
