package ttps.clasificados;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
public class ContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ContextListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		String nombre = sce.getServletContext().getInitParameter("nombre");
		String email = sce.getServletContext().getInitParameter("email");
		String telefono = sce.getServletContext().getInitParameter("telefono");
		sce.getServletContext().setAttribute("sitio", new SitioClasificado(nombre, email, telefono));
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
