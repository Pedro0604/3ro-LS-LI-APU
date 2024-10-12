package clasesDAOImplJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.MensajesDAO;
import clasesObjetosSistema.Mensaje;
import emf.EMF;

public class MensajesDAOJPA implements MensajesDAO {

	@Override
	public List<Mensaje> load() {
		List<Mensaje> mensajes = new ArrayList<>();

		EntityManager em = EMF.getEMF().createEntityManager();
		Query query = em.createQuery("SELECT m FROM " + Mensaje.class.getSimpleName() + " m");
		try {
			mensajes = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error de JPA: " + e.getMessage());
		} finally {
			em.close();
		}
		return mensajes;
	}

	@Override
	public Mensaje get(int id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Mensaje mensaje = em.find(Mensaje.class, id);
		em.close();
		return mensaje;
	}

	@Override
	public boolean save(Mensaje mensaje) {
		boolean exito = false;
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = null;
		try {
			etx = em.getTransaction();
			etx.begin();
			em.persist(mensaje);
			etx.commit();
		} catch (RuntimeException e) {
			if (etx != null && etx.isActive()) {
				etx.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
		return exito;
	}

}
