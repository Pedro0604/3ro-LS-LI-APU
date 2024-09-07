
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
public class FiltroLogDeAccesos extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public FiltroLogDeAccesos() {
		super();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String ipAdress = request.getRemoteAddr();

		SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		Date currentDate = new Date();
		String formattedDate = dateFormat.format(currentDate);

		String method = httpRequest.getMethod();
		String requestURI = httpRequest.getRequestURI();
		String protocol = httpRequest.getProtocol();
		String requestLine = method + " " + requestURI + " " + protocol;

		String userAgent = httpRequest.getHeader("User-Agent");

		String log = ipAdress + " " + formattedDate + " \"" + requestLine + "\"" + " " + userAgent;

		request.getServletContext().log(log);
		System.out.println(log);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
