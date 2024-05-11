package ar.edu.unlp.info.oo2.ejercicio22.creators;

import ar.edu.unlp.info.oo2.ejercicio22.Elemento;
import ar.edu.unlp.info.oo2.ejercicio22.NullElemento;
import ar.edu.unlp.info.oo2.ejercicio22.Sandwich;

public class SandwichVeganoCreator extends SandwichCreator {
	@Override
	public Sandwich createSandwich() {
		return new Sandwich(new Elemento("Pan integral", 100), new Elemento("Salsa criolla", 20),
				new Elemento("Milanesa de girgolas", 500), new NullElemento());
	}
}
