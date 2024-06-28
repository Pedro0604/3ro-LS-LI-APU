package ar.edu.unlp.info.oo2.ejercicio15_otra_forma;

import java.time.LocalDate;

public abstract class AbstractFile {
	public abstract String prettyPrint();

	public abstract String getNombre();

	public abstract String getExtension();

	public abstract String getPermisos();

	public abstract int getTamanio();

	public abstract LocalDate getFechaCreacion();

	public abstract LocalDate getFechaModificacion();

	public abstract AbstractFile removeFilter();
}
