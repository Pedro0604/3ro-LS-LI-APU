package ar.edu.unlp.info.oo2.ejercicio_22_con_builder;

import ar.edu.unlp.info.oo2.ejercicio_22_con_builder.builders.SandwichBuilder;

public class SubteWayDirector {
	public Sandwich construir(SandwichBuilder builder) {
		builder.crearSandwich();
		builder.ponerPan();
		builder.ponerAderezo();
		builder.ponerPrincipal();
		builder.ponerAdicional();
		return builder.cerrarSandwich();
	}
}
