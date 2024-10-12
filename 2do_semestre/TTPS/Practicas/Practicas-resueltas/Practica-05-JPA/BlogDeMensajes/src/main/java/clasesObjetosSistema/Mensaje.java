package clasesObjetosSistema;

public class Mensaje {
	private String mensaje;
	private Usuario usuario;

	public Mensaje(String mensaje, Usuario usuario) {
		super();
		this.mensaje = mensaje;
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String toHTMLString() {
		return "<div class='mensaje'>" + "<p>" + mensaje + "</p>" + this.usuario.toHTMLString() + "</div>";
	}
}
