package ar.edu.unlp.info.oo2.ejercicio19_b.creators;

import ar.edu.unlp.info.oo2.ejercicio19_b.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19_b.armaduras.ArmaduraDeAcero;
import ar.edu.unlp.info.oo2.ejercicio19_b.armas.Espada;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.CombateCuerpoACuerpo;

public class GuerreroCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje(String nombre) {
		Personaje p = new Personaje(nombre, new Espada(), new ArmaduraDeAcero());
		p.addHabilidad(new CombateCuerpoACuerpo());
		return p;
	}
}
