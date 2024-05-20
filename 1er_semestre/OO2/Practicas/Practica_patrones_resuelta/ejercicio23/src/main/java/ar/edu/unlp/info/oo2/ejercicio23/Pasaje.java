package ar.edu.unlp.info.oo2.ejercicio23;

import java.util.ArrayList;
import java.util.List;

public class Pasaje {
	private Pasajero pasajero;
	private List<Integer> nrosAsientos;
	private List<Tramo> tramos;
	private final double[] VALORES_DIARIOS = new double[] { 1, 1.01, 0.99, 0.95, 1, 1.01, 1.01 };

	public Pasaje(Pasajero pasajero) {
		this.pasajero = pasajero;
		this.nrosAsientos = new ArrayList<>();
		this.tramos = new ArrayList<>();
	}

	public double getRateRoundTrip() {
		if (!this.tramos.isEmpty()) {
			String primeraCiudad = this.tramos.get(0).getCiudadSalida();
			String ultimaCiudad = this.tramos.get(this.tramos.size() - 1).getCiudadLlegada();

			return primeraCiudad.equals(ultimaCiudad) ? 0.95 : 1;
		}
		return 0;
	}

	public double getRateMultiHop() {
		if (!this.tramos.isEmpty()) {
			return this.tramos.size() >= 3 ? 0.93 : 1;
		}
		return 0;
	}

	public double getRateDiario() {
		if (!this.tramos.isEmpty()) {
			return this.tramos.stream()
					.mapToDouble(vuelo -> VALORES_DIARIOS[vuelo.getFecha().getDayOfWeek().getValue() - 1])
					.reduce(1.0, (a, b) -> a * b);
		}
		return 0;
	}

	public double getCostoBase() {
		return this.tramos.stream().mapToDouble(v -> v.getCostoBase()).sum();
	}

	public double getPrecio() {
		return this.getCostoBase() * this.getRateDiario() * this.getRateRoundTrip() * this.getRateMultiHop();
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public List<Integer> getNrosAsientos() {
		return nrosAsientos;
	}

	public List<Tramo> getTramos() {
		return tramos;
	}

	public int getNroAsientoDeTramo(Tramo tramo) {
		int pos = this.tramos.indexOf(tramo);
		if (pos != -1) {
			return this.nrosAsientos.get(pos);
		}
		return -1;
	}

	public boolean addTramo(Tramo tramo, int nroAsiento) {
		if (!this.tramos.contains(tramo) && tramo.ocuparAsiento(nroAsiento)) {
			this.tramos.add(tramo);
			this.nrosAsientos.add(nroAsiento);
			return true;
		}
		return false;
	}

	public void removeTramo(Tramo tramo) {
		int pos = this.tramos.indexOf(tramo);
		if (pos != -1) {
			int nroAsiento = this.nrosAsientos.get(pos);
			this.tramos.remove(tramo);
			tramo.desocuparAsiento(nroAsiento);
			this.nrosAsientos.remove(pos);
		}
	}
}