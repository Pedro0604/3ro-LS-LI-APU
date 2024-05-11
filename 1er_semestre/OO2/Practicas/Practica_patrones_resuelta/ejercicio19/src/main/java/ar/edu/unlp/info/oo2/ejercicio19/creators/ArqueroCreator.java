package ar.edu.unlp.info.oo2.ejercicio19.creators;

import ar.edu.unlp.info.oo2.ejercicio19.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19.armaduras.ArmaduraDeCuero;
import ar.edu.unlp.info.oo2.ejercicio19.armas.Arco;
import ar.edu.unlp.info.oo2.ejercicio19.habilidades.CombateADistancia;

public class ArqueroCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje() {
		Personaje p = new Personaje("Legolas", new Arco(), new ArmaduraDeCuero());
		p.addHabilidad(new CombateADistancia());
		return p;
	}
}
