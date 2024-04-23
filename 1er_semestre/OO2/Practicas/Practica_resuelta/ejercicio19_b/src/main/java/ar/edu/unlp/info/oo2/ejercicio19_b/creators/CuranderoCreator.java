package ar.edu.unlp.info.oo2.ejercicio19_b.creators;

import ar.edu.unlp.info.oo2.ejercicio19_b.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19_b.armaduras.ArmaduraDeHierro;
import ar.edu.unlp.info.oo2.ejercicio19_b.armas.BastonDeMago;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.CombateADistancia;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.Curacion;

public class CuranderoCreator extends PersonajeCreator {
	@Override
	public Personaje createPersonaje(String nombre) {
		Personaje p = new Personaje(nombre, new BastonDeMago(), new ArmaduraDeHierro());
		p.addHabilidad(new Curacion());
		p.addHabilidad(new CombateADistancia());
		return p;
	}
}