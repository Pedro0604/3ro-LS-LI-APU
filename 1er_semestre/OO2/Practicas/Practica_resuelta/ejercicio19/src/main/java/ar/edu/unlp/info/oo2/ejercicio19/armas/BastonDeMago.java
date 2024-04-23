package ar.edu.unlp.info.oo2.ejercicio19.armas;

public class BastonDeMago implements Arma {
	@Override
	public int hacerDañoACuero() {
		return 2;
	}

	@Override
	public int hacerDañoAHierro() {
		return 1;
	}

	@Override
	public int hacerDañoAAcero() {
		return 1;
	}
}
