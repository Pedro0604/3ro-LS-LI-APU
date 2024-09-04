
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
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
		String servletPath = "/ImprimeCupon?text=" + request.getParameter("text").toUpperCase();
		String imageUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + servletPath;

		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset='UTF-8'>\r\n"
				+ "<title>Festival capital</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<form action='Index' id='form'\r\n"
				+ "		style='padding: 75px 15px; display: flex; justify-content: center;'>\r\n" + "		<div\r\n"
				+ "			style='display: flex; flex-direction: column; gap: 12px; max-width: 500px; text-align: center;'>\r\n"
				+ "			<h1>Festival capital</h1>\r\n" + "			<div>\r\n"
				+ "				<label for='text'>Texto: </label> <input  maxlength='13' type='text' name='text' value='"
				+ request.getParameter("text") + "'");

		out.println("\r\n" + "					id='text' placeholder='Texto'>\r\n"
				+ "				<button>Generar cupón</button>\r\n" + "			</div>");

		out.println(
				"<img style='display: block;-webkit-user-select: none;margin: auto;cursor: zoom-in;background-color: hsl(0, 0%, 90%);transition: background-color 300ms;' alt='Cupon' src='"
						+ imageUrl + "' width='500px'>");

		out.println("\r\n" + "		</div>\r\n" + "	</form>\r\n" + "	<script>\r\n"
				+ "		window.addEventListener('load', () => {\r\n"
				+ "            const input = document.getElementById(\"text\");\r\n" + "            input.focus();\r\n"
				+ "            const length = input.value.length;\r\n"
				+ "            input.setSelectionRange(length, length);\r\n" + "		})\r\n" + "	</script>\r\n"
				+ "</body>\r\n" + "</html>");
		out.close();
	}
}
