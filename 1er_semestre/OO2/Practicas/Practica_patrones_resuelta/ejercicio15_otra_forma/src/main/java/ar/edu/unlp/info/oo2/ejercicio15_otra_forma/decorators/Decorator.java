package ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators;

import java.time.LocalDate;

import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.AbstractFile;

public abstract class Decorator extends AbstractFile {
	protected AbstractFile file;

	public Decorator(AbstractFile file) {
		this.file = file;
	}

	public String getNombre() {
		return this.file.getNombre();
	}

	public String getExtension() {
		return this.file.getExtension();
	}

	public String getPermisos() {
		return this.file.getPermisos();
	}

	public int getTamanio() {
		return this.file.getTamanio();
	}

	public LocalDate getFechaCreacion() {
		return this.file.getFechaCreacion();
	}

	public LocalDate getFechaModificacion() {
		return this.file.getFechaModificacion();
	}

	@Override
	public AbstractFile removeFilter() {
		return this.file;
	}
}
