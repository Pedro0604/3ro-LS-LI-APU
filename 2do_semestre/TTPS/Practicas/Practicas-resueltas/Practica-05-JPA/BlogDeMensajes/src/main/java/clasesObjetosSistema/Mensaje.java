package clasesObjetosSistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mensaje {
	@Id
	@GeneratedValue
	private long id;
	private String mensaje;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Mensaje() {
	}

	public Mensaje(long id, String mensaje, Usuario usuario) {
		this.id = id;
		this.mensaje = mensaje;
		this.usuario = usuario;
	}

	public Mensaje(String mensaje, Usuario usuario) {
		super();
		this.mensaje = mensaje;
		this.usuario = usuario;
	}

	public long getId() {
		return this.id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toHTMLString() {
		return "<div class='mensaje'>" + "<p>" + mensaje + "</p>" + this.usuario.toHTMLString() + "</div>";
	}
}
