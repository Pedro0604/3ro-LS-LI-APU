package ar.edu.unlp.info.oo2.ejercicio15.decorators;

import ar.edu.unlp.info.oo2.ejercicio15.File;

public class FileModificationDateDecorator extends FileDecorator {

	public FileModificationDateDecorator(File archivo) {
		super(archivo);
	}

	@Override
	public String prettyPrint() {
		return this.archivo.getFechaModificacion() + " - " + this.archivo.prettyPrint();
	}
}