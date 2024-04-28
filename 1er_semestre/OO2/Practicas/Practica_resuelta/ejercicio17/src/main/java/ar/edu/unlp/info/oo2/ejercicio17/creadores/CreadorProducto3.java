package ar.edu.unlp.info.oo2.ejercicio17.creadores;

import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraBonoAltoRiesgo;
import ar.edu.unlp.info.oo2.ejercicio17.productos.CompraBonoBajoRiesgo;
import ar.edu.unlp.info.oo2.ejercicio17.productos.PlazoFijo;
import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoCombinado;
import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoFinanciero;

public class CreadorProducto3 extends Creador {
	public ProductoFinanciero crearProducto(double valorCompraDolares, double valorCompraPesos,
			int cantidadDiasPlazoFijo, double tasaInteres, int parkingBajoRiesgo, int parkingAltoRiesgo) {
		ProductoFinanciero producto = new ProductoCombinado();
		producto.addProducto(new CompraBonoAltoRiesgo(parkingAltoRiesgo));
		producto.addProducto(new CompraBonoBajoRiesgo(parkingBajoRiesgo));
		producto.addProducto(new PlazoFijo(cantidadDiasPlazoFijo, tasaInteres));
		return producto;
	}
}
