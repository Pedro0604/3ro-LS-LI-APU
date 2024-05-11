package ar.edu.unlp.info.oo2.ejercicio22.creators;

import ar.edu.unlp.info.oo2.ejercicio22.Elemento;
import ar.edu.unlp.info.oo2.ejercicio22.NullElemento;
import ar.edu.unlp.info.oo2.ejercicio22.Sandwich;

public class SandwichVegetarianoCreator extends SandwichCreator {
	@Override
	public Sandwich createSandwich() {
		return new Sandwich(new Elemento("Pan con semillas", 120), new NullElemento(),
				new Elemento("Provoleta grillada", 200), new Elemento("Berenjenas al escabeche", 100));
	}
}
