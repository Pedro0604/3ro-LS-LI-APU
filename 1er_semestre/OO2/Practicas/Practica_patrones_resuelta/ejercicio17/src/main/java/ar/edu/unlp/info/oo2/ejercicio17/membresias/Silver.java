package ar.edu.unlp.info.oo2.ejercicio17.membresias;

import ar.edu.unlp.info.oo2.ejercicio17.creadores.Creador;

public class Silver extends Membresia {
	@Override
	public boolean puedeAccederAProducto(Creador creadorProducto) {
		return creadorProducto.puedeSerAccedidoPorSilver();
	}

	@Override
	public double getTasaInteres() {
		return 0.05 / 365;
	}

	@Override
	public int getPlazoMinimo() {
		return 35;
	}

	@Override
	public int periodoMinimoParking() {
		return 72;
	}
}
