package ar.edu.unlp.info.oo2.ejercicio17.membresias;

import ar.edu.unlp.info.oo2.ejercicio17.creadores.Creador;

public abstract class Membresia {
	public abstract boolean puedeAccederAProducto(Creador creadorProducto);

	public abstract double getTasaInteres();

	public abstract int getPlazoMinimo();

	public abstract int periodoMinimoParking();
}
