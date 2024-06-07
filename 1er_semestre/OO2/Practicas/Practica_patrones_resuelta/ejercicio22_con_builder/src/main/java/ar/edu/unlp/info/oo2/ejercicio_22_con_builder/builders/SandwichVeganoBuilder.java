package ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders;

import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.Elemento;

public class SandwichVeganoBuilder extends SandwichBuilder {
	@Override
	public void ponerPan() {
		this.sandwich.addElemento(new Elemento("Pan integral", 100));
	}

	@Override
	public void ponerAderezo() {
		this.sandwich.addElemento(new Elemento("Salsa criolla", 20));
	}

	@Override
	public void ponerPrincipal() {
		this.sandwich.addElemento(new Elemento("Milanesa de girgolas", 500));
	}

	@Override
	public void ponerAdicional() {
	}
}
