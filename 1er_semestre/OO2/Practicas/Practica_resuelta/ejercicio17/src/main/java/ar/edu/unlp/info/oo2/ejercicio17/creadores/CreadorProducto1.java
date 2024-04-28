package ar.edu.unlp.info.oo2.ejercicio17.creadores;

import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraDolares;
import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraPesos;
import ar.edu.unlp.info.oo2.ejercicio17.productos.PlazoFijo;
import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoCombinado;
import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoFinanciero;

public class CreadorProducto1 extends Creador {
	public ProductoFinanciero crearProducto(double valorCompraDolares, double valorCompraPesos,
			int cantidadDiasPlazoFijo, double tasaInteres, int parkingBajoRiesgo, int parkingAltoRiesgo) {
		ProductoFinanciero producto = new ProductoCombinado();
		producto.addProducto(new CompraDolares(valorCompraDolares));
		producto.addProducto(new PlazoFijo(cantidadDiasPlazoFijo, tasaInteres));
		producto.addProducto(new CompraPesos(valorCompraPesos));
		return producto;
	}

	@Override
	public boolean puedeSerAccedidoPorGold() {
		return false;
	}
}
