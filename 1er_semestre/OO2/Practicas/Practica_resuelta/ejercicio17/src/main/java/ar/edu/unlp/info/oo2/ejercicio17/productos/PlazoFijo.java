package ar.edu.unlp.info.oo2.ejercicio17.productos;

public class PlazoFijo extends ProductoFinanciero {
	private int cantidadDias;
	private double interes;

	public PlazoFijo(int cantidadDias, double interes) {
		super();
		this.cantidadDias = cantidadDias;
		this.interes = interes;
	}

	@Override
	public double retornoInversion(double montoInversion) {
		double suma = montoInversion;
		for (int i = 0; i < cantidadDias; i++) {
			suma *= (1 + interes);
		}
		return suma;
	}
}
