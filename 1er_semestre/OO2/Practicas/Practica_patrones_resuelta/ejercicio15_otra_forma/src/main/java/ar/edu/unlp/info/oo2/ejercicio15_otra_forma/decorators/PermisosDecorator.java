package ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators;

import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.AbstractFile;

public class PermisosDecorator extends Decorator {
	public PermisosDecorator(AbstractFile file) {
		super(file);
	}

	@Override
	public String prettyPrint() {
		return this.file.prettyPrint() + " - Permisos: " + this.file.getPermisos();
	}
}