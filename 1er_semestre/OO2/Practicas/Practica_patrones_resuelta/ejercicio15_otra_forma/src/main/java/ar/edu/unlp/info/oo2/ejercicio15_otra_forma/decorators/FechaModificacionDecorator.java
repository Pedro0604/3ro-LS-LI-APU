package ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators;

import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.AbstractFile;

public class FechaModificacionDecorator extends Decorator {
	public FechaModificacionDecorator(AbstractFile file) {
		super(file);
	}

	@Override
	public String prettyPrint() {
		return this.file.prettyPrint() + " - Fecha modifcación: " + this.file.getFechaModificacion();
	}
}