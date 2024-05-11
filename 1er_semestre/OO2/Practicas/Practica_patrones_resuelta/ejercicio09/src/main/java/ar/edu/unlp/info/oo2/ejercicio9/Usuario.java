package ar.edu.unlp.info.oo2.ejercicio9;

public class Usuario {
	@SuppressWarnings("unused")
	private String nombre, apellido, email;

	public Usuario(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
}
