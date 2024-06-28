package ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators;

import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.AbstractFile;

public class NombreDecorator extends Decorator {
	public NombreDecorator(AbstractFile file) {
		super(file);
	}

	@Override
	public String prettyPrint() {
		return this.file.prettyPrint() + " - Nombre: " + this.file.getNombre();
	}
}