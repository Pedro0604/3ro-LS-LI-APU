package ar.edu.unlp.info.oo2.ejercicio19_b.armas;

public class Martillo implements Arma {

	@Override
	public int hacerDañoACuero() {
		return 12;
	}

	@Override
	public int hacerDañoAHierro() {
		return 11;
	}

	@Override
	public int hacerDañoAAcero() {
		return 10;
	}
}
