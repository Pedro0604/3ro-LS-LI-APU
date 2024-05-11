package ar.edu.unlp.info.oo2.ejercicio19_b.creators;

import ar.edu.unlp.info.oo2.ejercicio19_b.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19_b.armaduras.ArmaduraDeCuero;
import ar.edu.unlp.info.oo2.ejercicio19_b.armas.BastonDeMago;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.CombateADistancia;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.Magia;

public class MagoCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje(String nombre) {
		Personaje p = new Personaje(nombre, new BastonDeMago(), new ArmaduraDeCuero());
		p.addHabilidad(new Magia());
		p.addHabilidad(new CombateADistancia());
		return p;
	}
}
