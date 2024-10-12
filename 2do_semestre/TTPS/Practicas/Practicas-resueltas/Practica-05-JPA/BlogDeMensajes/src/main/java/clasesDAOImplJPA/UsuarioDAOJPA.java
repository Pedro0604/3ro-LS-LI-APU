package clasesDAOImplJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import clasesDAO.UsuarioDAO;
import clasesObjetosSistema.Usuario;
import emf.EMF;

public class UsuarioDAOJPA implements UsuarioDAO {

	@Override
	public Usuario get(long id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Usuario usuario = em.find(Usuario.class, id);
		em.close();
		return usuario;
	}

	@Override
	public List<Usuario> load() {
		List<Usuario> usuarios = new ArrayList<>();

		EntityManager em = EMF.getEMF().createEntityManager();
		Query query = em.createQuery("SELECT u FROM " + Usuario.class.getSimpleName() + " u");
		try {
			usuarios = (List<Usuario>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Error de JPA: " + e.getMessage());
		} finally {
			em.close();
		}
		return usuarios;
	}
}
