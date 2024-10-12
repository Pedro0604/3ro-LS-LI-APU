package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import clasesDAO.FactoryDAO;
import clasesDAO.UsuarioDAO;
import clasesObjetosSistema.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarMensaje
 */
public class AgregarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarMensaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
		List<Usuario> usuarios = uDAO.load();

		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Agregar un mensaje</title>\r\n" + "<style>* {box-sizing: border-box;}\r\n" + "    body {\r\n"
				+ "        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n"
				+ "        background-color: #f0f2f5;\r\n" + "        color: #333;\r\n" + "        display: flex;\r\n"
				+ "        justify-content: center;\r\n" + "        align-items: center;\r\n"
				+ "        height: 100vh;\r\n" + "        margin: 0;\r\n" + "    }\r\n" + "\r\n"
				+ "    .form-container {\r\n" + "        background-color: #ffffff;\r\n"
				+ "        border-radius: 10px;\r\n" + "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\r\n"
				+ "        padding: 20px;\r\n" + "        max-width: 400px;\r\n" + "        width: 100%;\r\n"
				+ "    }\r\n" + "\r\n" + "    h1 {\r\n" + "        text-align: center;\r\n"
				+ "        margin-bottom: 20px;\r\n" + "        font-size: 1.8em;\r\n" + "        color: #333;\r\n"
				+ "    }\r\n" + "\r\n" + "    label {\r\n" + "        display: block;\r\n"
				+ "        margin-bottom: 10px;\r\n" + "        font-size: 1.1em;\r\n" + "    }\r\n" + "\r\n"
				+ "    textarea, select {\r\n" + "        width: 100%;\r\n" + "        padding: 10px;\r\n"
				+ "        margin-bottom: 20px;\r\n" + "        border-radius: 5px;\r\n"
				+ "        border: 1px solid #ccc;\r\n" + "        font-size: 1.1em;\r\n"
				+ "    	box-sizing: border-box;\r\n" + "    }\r\n" + "\r\n" + "    textarea {\r\n"
				+ "        height: 100px;\r\n" + "        resize: vertical;\r\n" + "    }\r\n" + "\r\n"
				+ "    .btn {\r\n" + "        display: inline-block;\r\n" + "        padding: 10px 20px;\r\n"
				+ "        background-color: #007BFF;\r\n" + "        color: white;\r\n"
				+ "        text-decoration: none;\r\n" + "        border-radius: 5px;\r\n"
				+ "        font-size: 1.1em;\r\n" + "        text-align: center;\r\n" + "        width: 100%;\r\n"
				+ "        cursor: pointer;\r\n" + "    }\r\n" + "\r\n" + "    .btn:hover {\r\n"
				+ "        background-color: #0056b3;\r\n" + "    }\r\n" + "    .error-container {\r\n"
				+ "        text-align: center;\r\n" + "        margin: 20px;\r\n" + "        padding: 15px;\r\n"
				+ "        background-color: #f8d7da;\r\n" + "        color: #721c24;\r\n"
				+ "        border: 1px solid #f5c6cb;\r\n" + "        border-radius: 5px;\r\n"
				+ "        max-width: 400px;\r\n" + "        width: 100%;\r\n" + "    }\r\n" + "\r\n"
				+ "    .error-container a {\r\n" + "        color: #007BFF;\r\n" + "        text-decoration: none;\r\n"
				+ "    }\r\n" + "\r\n" + "    .error-container a:hover {\r\n"
				+ "        text-decoration: underline;\r\n" + "    }\r\n" + "</style>\r\n" + "</head>\r\n"
				+ "<body>\r\n");

		if (usuarios.size() > 0) {
			out.println("<div class=\"form-container\">\r\n" + "    <h1>Agregar un mensaje</h1>\r\n"
					+ "    <form action=\"GuardarMensaje\" method=\"POST\">\r\n"
					+ "        <label for=\"mensaje\">Mensaje:</label>\r\n"
					+ "        <textarea id=\"mensaje\" name=\"mensaje\" placeholder=\"Escribe tu mensaje aquí...\" required></textarea>\r\n"
					+ "\r\n" + "        <label for=\"user-id\">ID de usuario:</label>\r\n"
					+ "        <select id=\"user-id\" name=\"user-id\" required>\r\n"
					+ "            <option value=\"\" disabled selected>Selecciona un usuario</option>");

			usuarios.forEach(usuario -> out.println("<option value='" + usuario.getId() + "'>" + usuario.getNombre()
					+ ", " + usuario.getApellido() + "</option>"));

			out.println("</select>\r\n" + "\r\n"
					+ "			<button type=\"submit\" class=\"btn\">Enviar mensaje</button>\r\n" + "		</form>\r\n"
					+ "	</div>");
		} else {
			out.println("<div class='error-container'>\r\n"
					+ "    <p>Error: No hay ningún usuario en el sistema al que asignarle el mensaje - Fijate q haces pa :)</p></div>");
		}
		out.println("</body>\r\n" + "</html>");

	}
}
