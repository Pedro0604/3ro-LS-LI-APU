package ar.edu.unlp.info.oo2.ejercicio22.creators;

import ar.edu.unlp.info.oo2.ejercicio22.Elemento;
import ar.edu.unlp.info.oo2.ejercicio22.Sandwich;

public class SandwichClasicoCreator extends SandwichCreator {
	@Override
	public Sandwich createSandwich() {
		return new Sandwich(new Elemento("Pan brioche", 100), new Elemento("Aderezo a base de mayonesa", 20),
				new Elemento("Carne de ternera", 300), new Elemento("Tomate", 80));
	}
}
