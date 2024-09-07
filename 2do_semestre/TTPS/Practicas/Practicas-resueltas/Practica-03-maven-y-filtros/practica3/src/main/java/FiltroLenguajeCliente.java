
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FiltroLenguajeCliente
 */
public class FiltroLenguajeCliente extends HttpFilter implements Filter {
	private List<String> supportedLanguages;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public FiltroLenguajeCliente() {
		super();
		this.supportedLanguages = new ArrayList<>();
		this.supportedLanguages.add("es");
		this.supportedLanguages.add("en");
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
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		Locale locale = httpRequest.getLocale();
		String language = locale.getLanguage();

		if (language == null || !this.supportedLanguages.contains(language)) {
			language = "es";
		}

		request.setAttribute("language", language);

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
