package ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders;

import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.Elemento;

public class SandwichClasicoBuilder extends SandwichBuilder {
	@Override
	public void ponerPan() {
		this.sandwich.addElemento(new Elemento("Pan brioche", 100));
	}

	@Override
	public void ponerAderezo() {
		this.sandwich.addElemento(new Elemento("Aderezo a base de mayonesa", 20));
	}

	@Override
	public void ponerPrincipal() {
		this.sandwich.addElemento(new Elemento("Carne de ternera", 300));
	}

	@Override
	public void ponerAdicional() {
		this.sandwich.addElemento(new Elemento("Tomate", 80));
	}
}
