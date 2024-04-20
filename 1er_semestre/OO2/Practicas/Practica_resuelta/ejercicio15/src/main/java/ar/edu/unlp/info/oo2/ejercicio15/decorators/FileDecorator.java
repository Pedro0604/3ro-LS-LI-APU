package ar.edu.unlp.info.oo2.ejercicio15.decorators;

import java.time.LocalDateTime;

import ar.edu.unlp.info.oo2.ejercicio15.File;

public abstract class FileDecorator implements File {
	protected File archivo;

	public FileDecorator(File archivo) {
		this.archivo = archivo;
	}

	@Override
	public String getNombre() {
		return this.archivo.getNombre();
	}

	@Override
	public String getExtension() {
		return this.archivo.getExtension();
	}

	@Override
	public String getPermisos() {
		return this.archivo.getPermisos();
	}

	@Override
	public int getTamanio() {
		return this.archivo.getTamanio();
	}

	@Override
	public LocalDateTime getFechaCreacion() {
		return this.archivo.getFechaCreacion();
	}

	@Override
	public LocalDateTime getFechaModificacion() {
		return this.archivo.getFechaModificacion();
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	public abstract String prettyPrint();
}
