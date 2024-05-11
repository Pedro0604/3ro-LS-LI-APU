package ar.edu.unlp.info.oo2.ejercicio17.productos;

import java.util.ArrayList;
import java.util.List;

public class ProductoCombinado extends ProductoFinanciero {
	private List<ProductoFinanciero> productos;

	public ProductoCombinado() {
		super();
		this.productos = new ArrayList<>();
	}

	public void addProducto(ProductoFinanciero producto) {
		this.productos.add(producto);
	}

	@Override
	public double retornoInversion(double montoInversion) {
		return this.productos.stream().mapToDouble(p -> p.retornoInversion(montoInversion)).sum();
	}
}
