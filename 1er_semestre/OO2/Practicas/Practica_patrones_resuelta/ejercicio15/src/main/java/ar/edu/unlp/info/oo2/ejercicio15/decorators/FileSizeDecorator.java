package ar.edu.unlp.info.oo2.ejercicio15.decorators;

import ar.edu.unlp.info.oo2.ejercicio15.File;

public class FileSizeDecorator extends FileDecorator {

	public FileSizeDecorator(File archivo) {
		super(archivo);
	}

	@Override
	public String prettyPrint() {
		return this.archivo.getTamanio() + " - " + this.archivo.prettyPrint();
	}
}