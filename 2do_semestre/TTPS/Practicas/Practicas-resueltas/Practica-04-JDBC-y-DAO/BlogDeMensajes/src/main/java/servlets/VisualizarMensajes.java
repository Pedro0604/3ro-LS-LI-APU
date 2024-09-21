package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import clasesDAO.MensajesDAO;
import clasesDAOImpljdbc.FactoryDAO;
import clasesObjetosSistema.Mensaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisualizarMensajes
 */
public class VisualizarMensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizarMensajes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MensajesDAO mDAO = FactoryDAO.getMensajeDAO();
		List<Mensaje> mensajes = mDAO.load();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Mensajes</title>\r\n" + "<style>\r\n* {box-sizing: border-box;}"
				+ "html, body { height: 100%; margin: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f2f5; color: #333; }\r\n"
				+ "body { display: flex; flex-direction: column; justify-content: space-between; }\r\n"
				+ "h1 { color: #333; text-align: center; font-size: 2.5em; margin-bottom: 20px; }\r\n"
				+ ".btn { display: inline-block; padding: 10px 20px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px; font-size: 1.1em; margin-bottom: 20px; }\r\n"
				+ ".btn:hover { background-color: #0056b3; }\r\n"
				+ ".container { max-width: 800px; margin: 0 auto; flex: 1; display: flex; flex-direction: column; justify-content: flex-start; align-items: center; }\r\n"
				+ ".mensaje { background-color: #ffffff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; margin: 15px 0; width: 100%; }\r\n"
				+ ".mensaje p { font-size: 1.2em; margin: 0 0 10px; }\r\n"
				+ ".usuario { font-size: 0.9em; color: #888; text-align: right; margin-top: 10px; }\r\n"
				+ ".no-mensajes { text-align: center; font-size: 1.5em; color: #555; padding: 20px; background-color: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }\r\n"
				+ "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "<div class='container'>\r\n"
				+ "<h1>Lista de Mensajes</h1>\r\n" + "<a href='AgregarMensaje' class='btn'>Agregar un mensaje</a>\r\n");

		if (mensajes.size() > 0) {
			mensajes.forEach(mensaje -> out.println(mensaje.toHTMLString()));
		} else {
			out.println("<div class='no-mensajes'>No hay mensajes disponibles.</div>");
		}

		out.println("</div></body>\r\n</html>");
	}
}