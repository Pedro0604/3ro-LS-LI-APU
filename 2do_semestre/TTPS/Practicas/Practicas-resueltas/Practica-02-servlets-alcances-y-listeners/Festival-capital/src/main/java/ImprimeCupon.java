
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImprimeCupon
 */
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImprimeCupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigoRetiro = ThreadLocalRandom.current().nextInt(1000000, 99999999);
		String text = (String) request.getParameter("text").trim();
		if (text.length() > 13) {
			text = text.substring(0, 13);
		}

		OutputStream outputStream = response.getOutputStream();
		BufferedImage image = new BufferedImage(2044, 1173, BufferedImage.TYPE_INT_BGR);
		Graphics2D graphics = image.createGraphics();
		graphics.setBackground(Color.WHITE);
		graphics.clearRect(0, 0, 2044, 1173);

		BufferedImage img = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/cupon.jpg"));
		graphics.drawImage(img, 0, 0, null, null);

		graphics.setFont(new Font("TimesRoman", Font.BOLD, 50));
		graphics.setColor(Color.WHITE);
		graphics.drawString(text, (int) Math.ceil(480 + (170 - text.length() * 16.5)), 925);

		graphics.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
		graphics.setColor(Color.YELLOW);
		graphics.drawString("#" + codigoRetiro, 1450, 1025);

		javax.imageio.ImageIO.write(image, "png", outputStream);
		outputStream.close();
	}

}
