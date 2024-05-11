package ar.edu.unlp.info.oo2.ejercicio17.membresias;

import ar.edu.unlp.info.oo2.ejercicio17.creadores.Creador;

public class Gold extends Membresia {
	@Override
	public boolean puedeAccederAProducto(Creador creadorProducto) {
		return creadorProducto.puedeSerAccedidoPorGold();
	}

	@Override
	public double getTasaInteres() {
		return 0.06 / 365;
	}

	@Override
	public int getPlazoMinimo() {
		return 30;
	}

	@Override
	public int periodoMinimoParking() {
		return 24;
	}
}
