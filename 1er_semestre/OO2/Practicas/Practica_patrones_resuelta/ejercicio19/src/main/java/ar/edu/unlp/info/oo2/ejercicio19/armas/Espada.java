package ar.edu.unlp.info.oo2.ejercicio19.armas;

public class Espada implements Arma {
	@Override
	public int hacerDañoACuero() {
		return 8;
	}

	@Override
	public int hacerDañoAHierro() {
		return 5;
	}

	@Override
	public int hacerDañoAAcero() {
		return 3;
	}
}
