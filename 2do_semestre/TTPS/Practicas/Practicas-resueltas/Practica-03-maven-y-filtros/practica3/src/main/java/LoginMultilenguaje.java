
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMultilenguaje
 */
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginMultilenguaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String language = (String) request.getAttribute("language");

		ResourceBundle rb = ResourceBundle.getBundle("textos_" + language);
		String titulo = rb.getString("titulo");
		String labelUsuario = rb.getString("labelusuario");
		String labelPassword = rb.getString("labelpassword");
		String labelLogin = rb.getString("labellogin");

		out.println("<html lang=\"" + language + "\">");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<meta name='description' content='Login Page'>");
		out.println("<meta name='author' content='Your Name'>");
		out.println("<meta http-equiv='Content-Language' content='en'>");
		out.println("<title>" + titulo + "</title>");
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }");
		out.println("h2 { color: #333; margin-top: 0; }");
		out.println(
				"#form { max-width: 400px; margin: 50px auto; padding: 20px; background: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
		out.println(
				"input { width: calc(100% - 22px); padding: 10px; margin: 10px 0; border: 1px solid #ddd; border-radius: 5px; }");
		out.println("input[type='submit'] { background-color: #5cb85c; color: white; border: none; cursor: pointer; }");
		out.println("input[type='submit']:hover { background-color: #4cae4c; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='form'>");
		out.println("<h2>" + titulo + "</h2>");
		out.println(labelUsuario + ": <input type='text' name='username' required><br>");
		out.println(labelPassword + ": <input type='password' name='password' required><br>");
		out.println("<input type='submit' value='" + labelLogin + "'>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
