package ttps.clasificados;

public class Publicador extends Usuario {

	public Publicador(String nombre, String clave) {
		super(nombre, clave);
	}

	@Override
	public String getRutaPerfil() {
		return "publicador.html";
	}

	@Override
	public String getPerfil() {
		return "Publicador";
	}
}
