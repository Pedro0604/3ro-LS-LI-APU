package entregable1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Estadistica
 */
@WebServlet("/Estadistica")
public class Estadistica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Estadistica() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cantidadAbonosDosDiasVendidos = (int) request.getServletContext()
				.getAttribute("cantidadAbonosDosDiasVendidos");
		int cantidadAbonosTresDiasVendidos = (int) request.getServletContext()
				.getAttribute("cantidadAbonosTresDiasVendidos");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\n" + "<html lang=\"es\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>Reporte de Entradas</title>\n" + "    <style>\n" + "        body {\n"
				+ "            font-family: Arial, sans-serif;\n" + "            background-color: #f4f4f4;\n"
				+ "            margin: 0;\n" + "            padding: 20px;\n" + "            color: #333;\n"
				+ "        }\n" + "        .container {\n" + "            max-width: 600px;\n"
				+ "            margin: auto;\n" + "            padding: 20px;\n" + "            background: #fff;\n"
				+ "            border-radius: 8px;\n" + "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n"
				+ "        }\n" + "        h1 {\n" + "            text-align: center;\n"
				+ "            color: #007bff;\n" + "        }\n" + "        .report {\n"
				+ "            font-size: 18px;\n" + "            line-height: 1.6;\n"
				+ "            text-align: center;\n" + "        }\n" + "        .highlight {\n"
				+ "            font-weight: bold;\n" + "            color: #dc3545; /* Color rojo para destacar */\n"
				+ "        }\n" + "    </style>\n" + "</head>\n" + "<body>\n" + "    <div class=\"container\">\n"
				+ "        <h1>Reporte de Entradas Vendidas</h1>\n" + "        <div class=\"report\">\n"
				+ "            Se vendieron un total de <span class=\"highlight\">" + cantidadAbonosDosDiasVendidos
				+ " entradas</span> de dos días y <span class=\"highlight\">" + cantidadAbonosTresDiasVendidos
				+ " entradas</span> de tres días.\n" + "        </div>\n" + "    </div>\n" + "</body>\n" + "</html>\n"
				+ "");
		out.close();
	}
}
