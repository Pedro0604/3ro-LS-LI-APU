package ar.edu.unlp.info.oo2.ejercicio19_b.creators;

import ar.edu.unlp.info.oo2.ejercicio19_b.Personaje;
import ar.edu.unlp.info.oo2.ejercicio19_b.armaduras.ArmaduraDeHierro;
import ar.edu.unlp.info.oo2.ejercicio19_b.armas.Martillo;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.CombateADistancia;
import ar.edu.unlp.info.oo2.ejercicio19_b.habilidades.LanzarRayos;

public class CreaThOOr extends PersonajeCreator {
	@Override
	public Personaje createPersonaje(String nombre) {
		Personaje p = new Personaje(nombre, new Martillo(), new ArmaduraDeHierro());
		p.addHabilidad(new LanzarRayos());
		p.addHabilidad(new CombateADistancia());
		return p;
	}
}
