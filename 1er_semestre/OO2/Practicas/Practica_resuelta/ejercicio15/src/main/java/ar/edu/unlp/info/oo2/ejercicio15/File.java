package ar.edu.unlp.info.oo2.ejercicio15;

import java.time.LocalDateTime;

public interface File {
	public String prettyPrint();

	public String getNombre();

	public String getExtension();

	public String getPermisos();

	public int getTamanio();

	public LocalDateTime getFechaCreacion();

	public LocalDateTime getFechaModificacion();
}
