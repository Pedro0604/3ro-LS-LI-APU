package ar.edu.unlp.info.oo2.ejercicio15.decorators;

import ar.edu.unlp.info.oo2.ejercicio15.File;

public class FilePermissionsDecorator extends FileDecorator {

	public FilePermissionsDecorator(File archivo) {
		super(archivo);
	}

	@Override
	public String prettyPrint() {
		return this.archivo.getPermisos() + " - " + this.archivo.prettyPrint();
	}
}