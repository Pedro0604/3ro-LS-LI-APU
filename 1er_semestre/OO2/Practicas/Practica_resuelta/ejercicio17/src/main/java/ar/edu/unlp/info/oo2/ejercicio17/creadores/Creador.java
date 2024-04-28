package ar.edu.unlp.info.oo2.ejercicio17.creadores;

import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoFinanciero;

public abstract class Creador {
	public abstract ProductoFinanciero crearProducto(double valorCompraDolares, double valorCompraPesos,
			int cantidadDiasPlazoFijo, double tasaInteres, int parkingBajoRiesgo, int parkingAltoRiesgo);

	public boolean puedeSerAccedidoPorSilver() {
		return true;
	}

	public boolean puedeSerAccedidoPorGold() {
		return true;
	}
}
