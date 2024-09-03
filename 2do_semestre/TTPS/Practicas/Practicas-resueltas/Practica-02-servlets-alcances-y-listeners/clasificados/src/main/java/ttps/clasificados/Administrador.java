package ttps.clasificados;

public class Administrador extends Usuario {

	public Administrador(String nombre, String clave) {
		super(nombre, clave);
	}

	@Override
	public String getRutaPerfil() {
		return "administrador.html";
	}

	@Override
	public String getPerfil() {
		return "Administrador";
	}
}
