package ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders;

import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.Elemento;

public class SandwichSinTACCBuilder extends SandwichBuilder {
	@Override
	public void ponerPan() {
		this.sandwich.addElemento(new Elemento("Pan de chipá", 150));
	}

	@Override
	public void ponerAderezo() {
		this.sandwich.addElemento(new Elemento("Salsa tártara", 18));
	}

	@Override
	public void ponerPrincipal() {
		this.sandwich.addElemento(new Elemento("Pollo", 250));
	}

	@Override
	public void ponerAdicional() {
		this.sandwich.addElemento(new Elemento("Verduras grilladas", 200));
	}
}
