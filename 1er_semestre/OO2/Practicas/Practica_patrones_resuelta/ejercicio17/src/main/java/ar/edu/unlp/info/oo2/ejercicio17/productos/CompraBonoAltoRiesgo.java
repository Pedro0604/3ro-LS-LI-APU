package ar.edu.unlp.info.oo2.ejercicio17.productos;

import java.time.LocalDate;

public class CompraBonoAltoRiesgo extends ProductoFinanciero {
	private int parking;
	private final double VARIACION_MAXIMA = 70;

	public CompraBonoAltoRiesgo(int parking) {
		super();
		this.parking = parking;
	}

	@Override
	public double retornoInversion(double montoInversion) {
		if (LocalDate.now().isAfter(this.fechaOperacion.plusDays(parking))) {
			double variacion = (Math.random() * VARIACION_MAXIMA * 2) - VARIACION_MAXIMA;
			return variacion * montoInversion;
		}
		return -1;
	}
}
