package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tramo {
	private LocalDate fecha;
	private Vuelo vuelo;
	private List<Boolean> asientosOcupados;

	public Tramo(LocalDate fecha, Vuelo vuelo) {
		this.fecha = fecha;
		this.vuelo = vuelo;
		this.asientosOcupados = new ArrayList<>();
		for (int i = 0; i < this.vuelo.getAvion().getCantAsientos(); i++) {
			this.asientosOcupados.add(i, false);
		}
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getId() {
		return this.vuelo.getId();
	}

	public String getCiudadSalida() {
		return this.vuelo.getCiudadSalida();
	}

	public String getCiudadLlegada() {
		return this.vuelo.getCiudadLlegada();
	}

	public LocalTime getHoraSalida() {
		return this.vuelo.getHoraSalida();
	}

	public LocalTime getHoraLlegada() {
		return this.vuelo.getHoraLlegada();
	}

	public double getCostoBase() {
		return this.vuelo.getCostoBase();
	}

	public boolean[] getFrecuencia() {
		return this.vuelo.getFrecuencia();
	}

	public Avion getAvion() {
		return this.vuelo.getAvion();
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

	public boolean isFromVuelo(Vuelo vuelo) {
		return this.vuelo.equals(vuelo);
	}

	public boolean isDateInPeriod(LocalDate fechaInicio, LocalDate fechaFin) {
		return (this.getFecha().isEqual(fechaInicio) || this.getFecha().isAfter(fechaInicio))
				&& (this.getFecha().isEqual(fechaFin) || this.getFecha().isBefore(fechaFin));
	}

	public double getPromedioOcupacion() {
		return this.getCantAsientosOcupados() / (double) this.getAvion().getCantAsientos();
	}

	public boolean isFromAvion(Avion avion) {
		return this.getAvion().equals(avion);
	}

	public double getHorasVoladas() {
		Duration duration = Duration.between(this.getHoraSalida(), this.getHoraLlegada());
		long seconds = duration.getSeconds();
		return seconds / 3600.0;
	}
}
