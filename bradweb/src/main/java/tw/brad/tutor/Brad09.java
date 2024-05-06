package tw.brad.tutor;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad09")
@MultipartConfig(
		location = "C:\\Users\\User\\git\\repository2\\bradweb\\src\\main\\webapp\\upload"
		)
public class Brad09 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part != null && part.getName().equals("upload") && part.getSize() > 0) {
				part.write(part.getSubmittedFileName());
			}
		}
	}

}
