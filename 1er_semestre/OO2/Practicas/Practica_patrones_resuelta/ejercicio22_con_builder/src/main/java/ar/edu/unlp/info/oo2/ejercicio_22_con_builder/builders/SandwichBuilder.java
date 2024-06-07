package ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders;

import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.Sandwich;

public abstract class SandwichBuilder {
	protected Sandwich sandwich;

	public void crearSandwich() {
		this.sandwich = new Sandwich();
	}

	public abstract void ponerPan();

	public abstract void ponerAderezo();

	public abstract void ponerPrincipal();

	public abstract void ponerAdicional();

	public Sandwich cerrarSandwich() {
		return this.sandwich;
	}
}
