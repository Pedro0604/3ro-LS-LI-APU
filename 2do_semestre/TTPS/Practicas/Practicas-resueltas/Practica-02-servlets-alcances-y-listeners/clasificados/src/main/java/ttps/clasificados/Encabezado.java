package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encabezado
 */
public class Encabezado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Encabezado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		SitioClasificado sitio = (SitioClasificado) this.getServletContext().getAttribute("sitio");

		out.println("<header style='background-color: #4CAF50; color: white; padding: 20px; text-align: center;'>");
		out.println("<h1 style='font-family: Arial, sans-serif; font-size: 2.5em;'>" + sitio.getNombre() + "</h1>");
		out.println(
				"<p style='font-family: Arial, sans-serif; font-size: 1.2em;'>Bienvenido a nuestro sitio web. Aquí encontrarás lo que necesitas.</p>");
		out.println("<p style='font-family: Arial, sans-serif; font-size: 1em;'>Email: " + sitio.getEmail()
				+ " | Teléfono: " + sitio.getTelefono() + "</p>");
		out.println("</header>");
	}
}
