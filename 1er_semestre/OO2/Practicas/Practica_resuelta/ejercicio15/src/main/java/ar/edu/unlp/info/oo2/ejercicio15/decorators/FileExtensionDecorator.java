package ar.edu.unlp.info.oo2.ejercicio15.decorators;

import ar.edu.unlp.info.oo2.ejercicio15.File;

public class FileExtensionDecorator extends FileDecorator {

	public FileExtensionDecorator(File archivo) {
		super(archivo);
	}

	@Override
	public String prettyPrint() {
		return this.archivo.getExtension() + " - " + this.archivo.prettyPrint();
	}
}