package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String perfil = (String) request.getAttribute("perfil");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Lionel Messi</title></head><body style='margin: 0'>");

		RequestDispatcher encabezadoDispatcher = getServletContext().getRequestDispatcher("/Encabezado");
		if (encabezadoDispatcher != null) {
			encabezadoDispatcher.include(request, response);
		}

		out.println("<div style='padding: 50px 15px; display: flex; align-items: center; flex-direction: column'>");

		out.println("<h1>Menú del perfil: " + perfil + "</h1>");

		if ("Administrador".equals(perfil)) {
			out.println("<ul>");
			out.println("<li>Actualizar datos de contacto</li>");
			out.println("<li>ABM de publicaciones</li>");
			out.println("<li>Contestar consultas</li>");
			out.println("</ul>");
		} else if ("Publicador".equals(perfil)) {
			out.println("<ul>");
			out.println("<li>Listar usuarios publicadores</li>");
			out.println("<li>ABM administradores</li>");
			out.println("<li>Ver estadísticas</li>");
			out.println("</ul>");
		} else {
			out.println("<p>Perfil desconocido.</p>");
		}
		out.println("<a href='login.html'> Volver al login </a>");
		out.println("</div>");

		out.println("</body></html>");
	}

}
