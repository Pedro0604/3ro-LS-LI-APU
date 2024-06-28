package ar.edu.unlp.info.oo2.ejercicio15_otra_forma.decorators;

import ar.edu.unlp.info.oo2.ejercicio15_otra_forma.AbstractFile;

public class TamanioDecorator extends Decorator {
	public TamanioDecorator(AbstractFile file) {
		super(file);
	}

	@Override
	public String prettyPrint() {
		return this.file.prettyPrint() + " - Tamaño: " + this.file.getTamanio();
	}
}