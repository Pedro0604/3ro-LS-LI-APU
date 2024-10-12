package clasesDAO;

import java.util.List;

import clasesObjetosSistema.Usuario;

public interface UsuarioDAO {
	public Usuario get(long id);

	public List<Usuario> load();
}
