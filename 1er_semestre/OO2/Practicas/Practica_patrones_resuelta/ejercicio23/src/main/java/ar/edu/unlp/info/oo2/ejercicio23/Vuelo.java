package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
	private LocalDate fecha;
	private TypeVuelo typeVuelo;
	private List<Boolean> asientosOcupados;

	public Vuelo(LocalDate fecha, TypeVuelo typeVuelo) {
		this.fecha = fecha;
		this.typeVuelo = typeVuelo;
		this.asientosOcupados = new ArrayList<>();
		for (int i = 0; i < this.typeVuelo.getAvion().getCantAsientos(); i++) {
			this.asientosOcupados.add(i, false);
		}
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getId() {
		return this.typeVuelo.getId();
	}

	public String getCiudadSalida() {
		return this.typeVuelo.getCiudadSalida();
	}

	public String getCiudadLlegada() {
		return this.typeVuelo.getCiudadLlegada();
	}

	public LocalTime getHoraSalida() {
		return this.typeVuelo.getHoraSalida();
	}

	public LocalTime getHoraLlegada() {
		return this.typeVuelo.getHoraLlegada();
	}

	public double getCostoBase() {
		return this.typeVuelo.getCostoBase();
	}

	public boolean[] getFrecuencia() {
		return this.typeVuelo.getFrecuencia();
	}

	public Avion getAvion() {
		return this.typeVuelo.getAvion();
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
