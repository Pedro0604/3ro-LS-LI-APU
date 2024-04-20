package ar.edu.unlp.info.oo2.ejercicio15.decorators;

import ar.edu.unlp.info.oo2.ejercicio15.File;

public class FileCreationDateDecorator extends FileDecorator {

	public FileCreationDateDecorator(File archivo) {
		super(archivo);
	}

	@Override
	public String prettyPrint() {
		return this.archivo.getFechaCreacion() + " - " + this.archivo.prettyPrint();
	}
}
