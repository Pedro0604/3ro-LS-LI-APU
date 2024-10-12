package clasesDAO;

import java.util.List;

import clasesObjetosSistema.Mensaje;

public interface MensajesDAO {
	public List<Mensaje> load();

	public Mensaje get(int id);

	public boolean save(Mensaje mensaje);
}
