package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import clasesDAO.FactoryDAO;
import clasesDAO.MensajesDAO;
import clasesDAO.UsuarioDAO;
import clasesObjetosSistema.Mensaje;
import clasesObjetosSistema.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuardarMensaje
 */
public class GuardarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuardarMensaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
		MensajesDAO mDAO = FactoryDAO.getMensajeDAO();

		String mensaje = request.getParameter("mensaje");
		String userId = request.getParameter("user-id");

		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Error en el formulario</title>\r\n" + "<style>* {box-sizing: border-box;}\r\n"
				+ "    body {\r\n" + "        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n"
				+ "        background-color: #f0f2f5;\r\n" + "        color: #333;\r\n" + "        display: flex;\r\n"
				+ "        justify-content: center;\r\n" + "        align-items: center;\r\n"
				+ "        height: 100vh;\r\n" + "        margin: 0;\r\n" + "    }\r\n" + "\r\n"
				+ "    .error-container {\r\n" + "        text-align: center;\r\n" + "        margin: 20px;\r\n"
				+ "        padding: 15px;\r\n" + "        background-color: #f8d7da;\r\n"
				+ "        color: #721c24;\r\n" + "        border: 1px solid #f5c6cb;\r\n"
				+ "        border-radius: 5px;\r\n" + "        max-width: 400px;\r\n" + "        width: 100%;\r\n"
				+ "    }\r\n" + "\r\n" + "    .error-container a {\r\n" + "        color: #007BFF;\r\n"
				+ "        text-decoration: none;\r\n" + "    }\r\n" + "\r\n" + "    .error-container a:hover {\r\n"
				+ "        text-decoration: underline;\r\n" + "    }\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>");
		if (mensaje != null && mensaje != "" && userId != null && userId != "") {
			Usuario usuario = uDAO.get(Integer.parseInt(userId));
			if (usuario != null) {
				mDAO.save(new Mensaje(mensaje, usuario));
				response.sendRedirect("mensajeGuardadoExitosamente.html");
			} else {
				out.println("<div class='error-container'>\r\n" + "    <p>Error: El usuario con ID " + userId
						+ " no existe.</p>\r\n" + "    <a href='AgregarMensaje'>Volver al formulario</a>\r\n"
						+ "</div>");
			}
		} else {
			out.println("<div class='error-container'>\r\n"
					+ "    <p>Error: El mensaje y el ID de usuario son obligatorios.</p>\r\n"
					+ "    <a href='AgregarMensaje'>Volver al formulario</a>\r\n</div>");
		}
		out.println("</body>\r\n" + "</html>");
	}
}
