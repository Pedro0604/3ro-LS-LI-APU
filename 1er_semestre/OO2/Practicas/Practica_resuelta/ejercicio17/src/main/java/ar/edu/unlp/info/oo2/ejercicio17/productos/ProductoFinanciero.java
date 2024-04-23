package ar.edu.unlp.info.oo2.ejercicio17.productos;

import java.time.LocalDate;

public abstract class ProductoFinanciero {
	protected LocalDate fechaOperacion;

	public ProductoFinanciero() {
		this.fechaOperacion = LocalDate.now();
	}

	public abstract double retornoInversion(double montoInicial);

	public void addProducto(ProductoFinanciero producto) {
	}
}
