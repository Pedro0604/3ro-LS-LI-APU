package ar.edu.unlp.info.oo2.ejercicio17.productos;

public class CompraDolares extends ProductoFinanciero {
	private double valorCompra;

	public CompraDolares(double valorCompra) {
		super();
		this.valorCompra = valorCompra;
	}

	@Override
	public double retornoInversion(double montoInversion) {
		return montoInversion / valorCompra;
	}
}
