package ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators;

import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.AbstractFile;

public class FechaCreacionDecorator extends Decorator {
	public FechaCreacionDecorator(AbstractFile file) {
		super(file);
	}

	@Override
	public String prettyPrint() {
		return this.file.prettyPrint() + " - Fecha creación: " + this.file.getFechaCreacion();
	}
}