package tw.brad.tutor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad17")
public class Brad17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String source = "C:\\Users\\User\\git\\repository2\\bradweb\\src\\main\\webapp\\upload\\bk14.jpg";
		BufferedImage img = ImageIO.read(new File(source));
		Graphics2D g2d = img.createGraphics();
		g2d.setColor(Color.BLUE);
		
		Font font1 = new Font(null, Font.BOLD, 256);
		AffineTransform af = new AffineTransform();
		af.rotate(Math.toRadians(30));
		Font font2 = font1.deriveFont(af);
		
		g2d.setFont(font2);
		g2d.drawString("資策會論壇專屬\n歡迎盜連", 1400, 1400);
		
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
		ImageIO.write(img, "JPEG", new File("c:\\brad\\ok.jpg"));
	}

}