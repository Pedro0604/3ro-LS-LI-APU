package ar.edu.unlp.info.oo2.ejercicio19.creators;

import ar.edu.unlp.info.oo2.ejercicio19.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19.armaduras.ArmaduraDeCuero;
import ar.edu.unlp.info.oo2.ejercicio19.armas.BastonDeMago;
import ar.edu.unlp.info.oo2.ejercicio19.habilidades.CombateADistancia;
import ar.edu.unlp.info.oo2.ejercicio19.habilidades.Magia;

public class MagoCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje() {
		Personaje p = new Personaje("Gandalf", new BastonDeMago(), new ArmaduraDeCuero());
		p.addHabilidad(new Magia());
		p.addHabilidad(new CombateADistancia());
		return p;
	}
}
