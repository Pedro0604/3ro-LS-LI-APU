package ar.edu.unlp.info.oo2.ejercicio15.decorators;

import ar.edu.unlp.info.oo2.ejercicio15.File;

public class FileNameDecorator extends FileDecorator {

	public FileNameDecorator(File archivo) {
		super(archivo);
	}

	@Override
	public String prettyPrint() {
		return this.archivo.getNombre() + " - " + this.archivo.prettyPrint();
	}
}