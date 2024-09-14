package entregable1;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CantidadAbonos
 *
 */
@WebListener("/*")
public class CantidadAbonos implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public CantidadAbonos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		int cantidadAbonosDosDias = Integer.parseInt(sce.getServletContext().getInitParameter("cantidadAbonosDosDias"));
		int cantidadAbonosTresDias = Integer
				.parseInt(sce.getServletContext().getInitParameter("cantidadAbonosDosDias"));

		sce.getServletContext().setAttribute("cantidadAbonosDosDias", cantidadAbonosDosDias);
		sce.getServletContext().setAttribute("cantidadAbonosTresDias", cantidadAbonosTresDias);
		sce.getServletContext().setAttribute("cantidadAbonosDosDiasVendidos", 0);
		sce.getServletContext().setAttribute("cantidadAbonosTresDiasVendidos", 0);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
