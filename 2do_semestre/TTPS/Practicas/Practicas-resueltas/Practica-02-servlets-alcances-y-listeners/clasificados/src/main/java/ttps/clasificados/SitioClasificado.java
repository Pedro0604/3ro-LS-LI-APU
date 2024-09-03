package ttps.clasificados;

public class SitioClasificado {
	private String nombre, email, telefono;

	public SitioClasificado(String nombre, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}
}
