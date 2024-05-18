package ar.edu.unlp.info.oo2.ejercicio23;

import java.util.ArrayList;
import java.util.List;

public class Pasaje {
	private Pasajero pasajero;
	private int nroAsiento;
	private List<Vuelo> vuelos;

	public Pasaje(Pasajero pasajero, int nroAsiento) {
		this.pasajero = pasajero;
		this.nroAsiento = nroAsiento;
		this.vuelos = new ArrayList<>();
	}

	private double getRateRoundTrip() {
		String primeraCiudad = this.vuelos.get(0).getCiudadSalida();
		String ultimaCiudad = this.vuelos.get(this.vuelos.size() - 1).getCiudadLlegada();

		return primeraCiudad.equals(ultimaCiudad) ? 0.95 : 1;
	}

	private double getRateMultiHop() {
		return this.vuelos.size() >= 3 ? 0.93 : 1;
	}

	private double getRateDiario(double[] valoresDiarios) {
		return this.vuelos.stream().mapToDouble(vuelo -> valoresDiarios[vuelo.getFecha().getDayOfWeek().getValue() - 1])
				.reduce(1.0, (a, b) -> a * b);
	}

	private double getCostoBase() {
		return this.vuelos.stream().mapToDouble(v -> v.getCostoBase()).sum();
	}

	public double getPrecio(double[] valoresDiarios) {
		return this.getCostoBase() * this.getRateDiario(valoresDiarios) * this.getRateRoundTrip()
				* this.getRateMultiHop();
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void addVuelo(Vuelo vuelo) {
		this.vuelos.add(vuelo);
		vuelo.ocuparAsiento(this.nroAsiento);
	}

	public void removeVuelo(Vuelo vuelo) {
		this.removeVuelo(vuelo);
		vuelo.desocuparAsiento(this.nroAsiento);
	}
}