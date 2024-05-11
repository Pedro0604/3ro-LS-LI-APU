package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pasaje {
	private Pasajero pasajero;
	private int nroAsiento;
	private LocalDate dia;
	private List<Vuelo> vuelos;
	private double[] valoresDiarios;

	public Pasaje(Pasajero pasajero, int nroAsiento, LocalDate dia) {
		this.pasajero = pasajero;
		this.nroAsiento = nroAsiento;
		this.dia = dia;
		this.vuelos = new ArrayList<>();
		this.valoresDiarios = new double[] { 1, 1.01, 0.99, 0.95, 1, 1.01, 1.01 };
	}

	private double getRateRoundTrip() {
		String primeraCiudad = this.vuelos.get(0).getCiudadSalida();
		String ultimaCiudad = this.vuelos.get(this.vuelos.size() - 1).getCiudadLlegada();

		return primeraCiudad.equals(ultimaCiudad) ? 0.95 : 1;
	}

	private double getRateMultiHop() {
		return this.vuelos.size() >= 3 ? 0.93 : 1;
	}

	private double getRateDiario() {
		return valoresDiarios[this.dia.getDayOfWeek().getValue() - 1];
	}

	private double getCostoBase() {
		return this.vuelos.stream().mapToDouble(v -> v.getCostoBase()).sum();
	}

	public double getPrecio() {
		return this.getCostoBase() * this.getRateDiario() * this.getRateRoundTrip() + this.getRateMultiHop();
	}
}