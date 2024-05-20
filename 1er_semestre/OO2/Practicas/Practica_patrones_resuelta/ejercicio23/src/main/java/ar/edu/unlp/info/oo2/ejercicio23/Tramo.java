package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tramo {
	private LocalDate fecha;
	private Vuelo vuelos;
	private List<Boolean> asientosOcupados;

	public Tramo(LocalDate fecha, Vuelo vuelo) {
		this.fecha = fecha;
		this.vuelos = vuelo;
		this.asientosOcupados = new ArrayList<>();
		for (int i = 0; i < this.vuelos.getAvion().getCantAsientos(); i++) {
			this.asientosOcupados.add(i, false);
		}
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getId() {
		return this.vuelos.getId();
	}

	public String getCiudadSalida() {
		return this.vuelos.getCiudadSalida();
	}

	public String getCiudadLlegada() {
		return this.vuelos.getCiudadLlegada();
	}

	public LocalTime getHoraSalida() {
		return this.vuelos.getHoraSalida();
	}

	public LocalTime getHoraLlegada() {
		return this.vuelos.getHoraLlegada();
	}

	public double getCostoBase() {
		return this.vuelos.getCostoBase();
	}

	public boolean[] getFrecuencia() {
		return this.vuelos.getFrecuencia();
	}

	public Avion getAvion() {
		return this.vuelos.getAvion();
	}

	public boolean isFull() {
		return !this.asientosOcupados.stream().anyMatch(isOcupado -> !isOcupado);
	}

	public int getCantAsientosOcupados() {
		return (int) this.asientosOcupados.stream().filter(isOcupado -> isOcupado).count();
	}

	private boolean isNroAsientoValido(int nroAsiento) {
		return nroAsiento >= 0 && nroAsiento < this.asientosOcupados.size();
	}

	public boolean ocuparAsiento(int nroAsiento) {
		if (this.isNroAsientoValido(nroAsiento) && !this.asientosOcupados.get(nroAsiento)) {
			this.asientosOcupados.set(nroAsiento, true);
			return true;
		}
		return false;
	}

	public void desocuparAsiento(int nroAsiento) {
		if (this.isNroAsientoValido(nroAsiento)) {
			this.asientosOcupados.set(nroAsiento, false);
		}
	}
}
