package entregable1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Servlet implementation class ImprimeEntrada
 */
@WebServlet("/ImprimeEntrada")
public class ImprimeEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImprimeEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		int dni = Integer.parseInt(request.getParameter("dni"));
		int entradasRequeridasDosDias = Integer.parseInt(request.getParameter("entradas-requeridas-dos"));
		int entradasRequeridasTresDias = Integer.parseInt(request.getParameter("entradas-requeridas-tres"));

		if (entradasRequeridasDosDias > 0) {
			int entradasDosDiasRestantes = (int) request.getServletContext().getAttribute("cantidadAbonosDosDias")
					- entradasRequeridasDosDias;
			request.getServletContext().setAttribute("cantidadAbonosDosDias", entradasDosDiasRestantes);

			int cantidadAbonosDosDiasVendidos = (int) request.getServletContext()
					.getAttribute("cantidadAbonosDosDiasVendidos") + entradasRequeridasDosDias;
			request.getServletContext().setAttribute("cantidadAbonosDosDiasVendidos", cantidadAbonosDosDiasVendidos);
		}
		if (entradasRequeridasTresDias > 0) {
			int entradasDosDiasRestantes = (int) request.getServletContext().getAttribute("cantidadAbonosTresDias")
					- entradasRequeridasDosDias;
			request.getServletContext().setAttribute("cantidadAbonosTresDias", entradasDosDiasRestantes);

			int cantidadAbonosTresDiasVendidos = (int) request.getServletContext()
					.getAttribute("cantidadAbonosTresDiasVendidos") + entradasRequeridasTresDias;
			request.getServletContext().setAttribute("cantidadAbonosTresDiasVendidos", cantidadAbonosTresDiasVendidos);
		}

		boolean ganoRemera = Math.random() > 0.7;

		String texto = "Entrada para " + name + " " + surname + " - DNI: " + dni + ". ";
		if (ganoRemera) {
			texto += "¡¡Felicitaciones!!, te ganaste una remera. El dia del evento pasa por el Stand TTPS y retirala con el QR";
		} else {
			texto += "No te ganaste una remera :( - Pero esperamos que disfrutes mucho el show!";
		}

		response.setContentType("image/png");
		try (OutputStream outputStream = response.getOutputStream()) {
			int ticketWidth = 1600;
			int ticketHeight = 741;
			BufferedImage ticketImage = new BufferedImage(ticketWidth, ticketHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = ticketImage.createGraphics();
			graphics.setBackground(Color.WHITE);
			graphics.clearRect(0, 0, ticketWidth, ticketHeight);

			BufferedImage logoImage = ImageIO
					.read(this.getServletContext().getResourceAsStream("/WEB-INF/logoQuilmes.jpeg"));
			graphics.drawImage(logoImage, 0, 0, null);

			int qrWidth = 300;
			int qrHeight = 300;
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			hints.put(EncodeHintType.MARGIN, 1);

			BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, qrWidth, qrHeight, hints);
			BufferedImage qrImage = new BufferedImage(qrWidth, qrHeight, BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < qrWidth; x++) {
				for (int y = 0; y < qrHeight; y++) {
					qrImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
				}
			}

			int logoHeight = logoImage.getHeight();
			int qrX = (ticketWidth - qrWidth) / 2;
			int qrY = logoHeight + 10;

			graphics.drawImage(qrImage, qrX, qrY, null);

			ImageIO.write(ticketImage, "png", outputStream);
			outputStream.flush();
		} catch (WriterException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al generar el código QR.");
		}

	}
}
