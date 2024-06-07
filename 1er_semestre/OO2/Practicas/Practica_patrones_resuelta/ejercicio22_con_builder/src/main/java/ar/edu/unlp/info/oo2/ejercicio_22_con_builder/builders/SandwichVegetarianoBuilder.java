package ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders;

import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.Elemento;

public class SandwichVegetarianoBuilder extends SandwichBuilder {
	@Override
	public void ponerPan() {
		this.sandwich.addElemento(new Elemento("Pan con semillas", 120));
	}

	@Override
	public void ponerAderezo() {
	}

	@Override
	public void ponerPrincipal() {
		this.sandwich.addElemento(new Elemento("Provoleta grillada", 200));
	}

	@Override
	public void ponerAdicional() {
		this.sandwich.addElemento(new Elemento("Berenjenas al escabeche", 100));
	}
}