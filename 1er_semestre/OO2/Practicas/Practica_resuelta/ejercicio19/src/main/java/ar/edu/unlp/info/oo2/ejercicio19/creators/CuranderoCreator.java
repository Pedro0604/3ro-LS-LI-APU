package ar.edu.unlp.info.oo2.ejercicio19.creators;

import ar.edu.unlp.info.oo2.ejercicio19.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19.armaduras.ArmaduraDeHierro;
import ar.edu.unlp.info.oo2.ejercicio19.armas.BastonDeMago;
import ar.edu.unlp.info.oo2.ejercicio19.habilidades.CombateADistancia;
import ar.edu.unlp.info.oo2.ejercicio19.habilidades.Curacion;

public class CuranderoCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje() {
		Personaje p = new Personaje("Mercy", new BastonDeMago(), new ArmaduraDeHierro());
		p.addHabilidad(new Curacion());
		p.addHabilidad(new CombateADistancia());
		return p;
	}
}