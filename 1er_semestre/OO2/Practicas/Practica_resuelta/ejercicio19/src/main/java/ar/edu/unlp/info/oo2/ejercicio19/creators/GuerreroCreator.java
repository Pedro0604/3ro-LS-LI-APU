package ar.edu.unlp.info.oo2.ejercicio19.creators;

import ar.edu.unlp.info.oo2.ejercicio19.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19.armaduras.ArmaduraDeAcero;
import ar.edu.unlp.info.oo2.ejercicio19.armas.Espada;
import ar.edu.unlp.info.oo2.ejercicio19.habilidades.CombateCuerpoACuerpo;

public class GuerreroCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje() {
		Personaje p = new Personaje("Cállate warrior", new Espada(), new ArmaduraDeAcero());
		p.addHabilidad(new CombateCuerpoACuerpo());
		return p;
	}
}
