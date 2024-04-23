package ar.edu.unlp.info.oo2.ejercicio19_b.creators;

import ar.edu.unlp.info.oo2.ejercicio19_b.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19_b.armaduras.ArmaduraDeCuero;
import ar.edu.unlp.info.oo2.ejercicio19_b.armas.Arco;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.CombateADistancia;

public class ArqueroCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje(String nombre) {
		Personaje p = new Personaje(nombre, new Arco(), new ArmaduraDeCuero());
		p.addHabilidad(new CombateADistancia());
		return p;
	}
}
