package clasesObjetosSistema;

public class Usuario {
	private int id;
	private String nombre, apellido, email;

	public Usuario(int id, String nombre, String apellido, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String toHTMLString() {
		return "<div class='usuario'>" + "Publicado por: " + nombre + " " + apellido + " (" + email + ")" + "</div>";
	}
}
