package clasesDAOImpljdbc;

import clasesDAO.MensajesDAO;
import clasesDAO.UsuarioDAO;

public class FactoryDAO {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOjdbc();
	}

	public static MensajesDAO getMensajeDAO() {
		return new MensajesDAOjdbc();
	}
}
