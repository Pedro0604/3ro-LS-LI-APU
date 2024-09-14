package entregable1;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet Filter implementation class FiltroEntradasAgotadas
 */
@WebFilter(urlPatterns = "/ImprimeEntrada", filterName = "FiltroEntradasAgotadas")
public class FiltroEntradasAgotadas extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	private FilterConfig config;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public FiltroEntradasAgotadas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		int cantidadAbonosDosDias = (int) this.config.getServletContext().getAttribute("cantidadAbonosDosDias");
		int cantidadAbonosTresDias = (int) this.config.getServletContext().getAttribute("cantidadAbonosTresDias");

		int entradasRequeridasDosDias = Integer.parseInt(request.getParameter("entradas-requeridas-dos"));
		int entradasRequeridasTresDias = Integer.parseInt(request.getParameter("entradas-requeridas-tres"));
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (cantidadAbonosDosDias == 0 && cantidadAbonosTresDias == 0) {
			httpResponse.sendRedirect("entradas-agotadas.html");
		} else if (entradasRequeridasTresDias > cantidadAbonosTresDias
				|| entradasRequeridasDosDias > cantidadAbonosDosDias) {
			httpResponse.sendRedirect("abono-solicitado-agotado.html");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
