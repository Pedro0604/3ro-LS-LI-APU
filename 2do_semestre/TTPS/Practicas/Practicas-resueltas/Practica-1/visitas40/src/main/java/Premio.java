
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Premio
 */
@WebServlet(description = "Premio", urlPatterns = { "/Premio" }, initParams = {
		@WebInitParam(name = "templateMessage", value = "¡Felicitaciones @! eres el visitante número # de nuestro sitio y has sido seleccionado para el gran premio TTPS - Cursada APROBADA", description = "Template message") })
public class Premio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int cantidad_requerimientos;

	/**
	 * Default constructor.
	 */
	public Premio() {
		cantidad_requerimientos = 0;
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cantidad_requerimientos++;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>God</title>\r\n" + "</head>\r\n" + "<body>\r\n");
		String message = this.getInitParameter("templateMessage");
		message = message.replace("@", request.getParameter("nombre")).replace("#",
				Integer.toString(this.cantidad_requerimientos));
		out.println(message);
		out.println("</body>\r\n" + "</html>");
		out.close();
	}

}
