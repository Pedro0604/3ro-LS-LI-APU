package ttps.clasificados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Administrador("Messi", "10"));
		this.usuarios.add(new Publicador("Pepe", "Argento"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		// Verificación de campos vacíos
		if (user == null || user.isEmpty() || password == null || password.isEmpty()) {
			response.sendRedirect("error.html");
			return;
		}

		Usuario usuarioLogueandose = new Publicador(user, password);
		Usuario usuario = this.usuarios.stream().filter(u -> u.equals(usuarioLogueandose)).findFirst().orElse(null);
		if (usuario == null) {
			response.sendRedirect("error.html");
			return;
		}
		request.setAttribute("perfil", usuario.getPerfil());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Menu");
		dispatcher.forward(request, response);
	}

}
