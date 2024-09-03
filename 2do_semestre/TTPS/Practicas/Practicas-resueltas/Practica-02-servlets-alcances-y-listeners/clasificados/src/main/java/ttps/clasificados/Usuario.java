package ttps.clasificados;

public abstract class Usuario {
	private String nombre, clave;

	public Usuario(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public String getClave() {
		return clave;
	}

	public abstract String getRutaPerfil();

	public abstract String getPerfil();

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario otroUsuario = (Usuario) obj;
			return this.nombre.equals(otroUsuario.getNombre()) && this.clave.equals(otroUsuario.getClave());
		} else {
			return false;
		}
	}
}
