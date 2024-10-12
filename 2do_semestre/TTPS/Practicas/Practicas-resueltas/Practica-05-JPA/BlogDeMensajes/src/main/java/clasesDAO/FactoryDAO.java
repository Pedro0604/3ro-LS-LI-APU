package clasesDAO;

import clasesDAOImplJPA.MensajesDAOJPA;
import clasesDAOImplJPA.UsuarioDAOJPA;

public class FactoryDAO {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOJPA();
	}

	public static MensajesDAO getMensajeDAO() {
		return new MensajesDAOJPA();
	}
}
