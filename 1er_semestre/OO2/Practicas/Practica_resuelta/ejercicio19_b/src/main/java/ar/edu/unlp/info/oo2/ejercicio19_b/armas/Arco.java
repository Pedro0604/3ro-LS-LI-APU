package ar.edu.unlp.info.oo2.ejercicio19_b.armas;

public class Arco implements Arma {

	@Override
	public int hacerDañoACuero() {
		return 5;
	}

	@Override
	public int hacerDañoAHierro() {
		return 3;
	}

	@Override
	public int hacerDañoAAcero() {
		return 2;
	}

}
