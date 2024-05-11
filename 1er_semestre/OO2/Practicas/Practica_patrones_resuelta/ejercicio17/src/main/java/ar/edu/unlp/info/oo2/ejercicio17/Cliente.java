package ar.edu.unlp.info.oo2.ejercicio17;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.oo2.ejercicio17.membresias.Membresia;
import ar.edu.unlp.info.oo2.ejercicio17.productos.ProductoFinanciero;

public class Cliente {
	private List<ProductoFinanciero> productos;
	private Membresia membresia;

	public Cliente(Membresia membresia) {
		this.membresia = membresia;
		this.productos = new ArrayList<>();
	}

	public void addProducto(ProductoFinanciero p) {
		this.productos.add(p);
	}

	public double retornoInversion(double montoInicial) {
		return this.productos.stream().mapToDouble(p -> p.retornoInversion(montoInicial)).sum();
	}
}
