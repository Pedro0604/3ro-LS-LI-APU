package ar.edu.unlp.info.oo2.ejercicio22.creators;

import ar.edu.unlp.info.oo2.ejercicio22.Elemento;
import ar.edu.unlp.info.oo2.ejercicio22.Sandwich;

public class SandwichSinTACCCreator extends SandwichCreator {
	@Override
	public Sandwich createSandwich() {
		return new Sandwich(new Elemento("Pan de chipá", 150), new Elemento("Salsa tártara", 18),
				new Elemento("Pollo", 250), new Elemento("Verduras grilladas", 200));
	}
}
