package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AerOOlinea {
	private List<Pasaje> pasajes;
	private List<Vuelo> vuelos;
	private List<Avion> aviones;

	public AerOOlinea() {
		this.pasajes = new ArrayList<>();
		this.aviones = new ArrayList<>();
		this.vuelos = new ArrayList<>();
	}

	public void addPasaje(Pasaje pasaje) {
		this.pasajes.add(pasaje);
	}

	public void modificarPasaje(Pasaje pasajeViejo, Pasaje pasajeNuevo) {
		this.pasajes.remove(pasajeViejo);
		this.pasajes.add(pasajeNuevo);
	}

	public boolean cancelarPasaje(Pasaje pasaje) {
		return this.pasajes.remove(pasaje);
	}

	public void addVuelo(Vuelo vuelo) {
		this.vuelos.add(vuelo);
	}

	public void addAvion(Avion avion) {
		this.aviones.add(avion);
	}

	public double getPromedioOcupacionEnPeriodo(Vuelo vuelo, LocalDate fechaInicio, LocalDate fechaFin) {
		return this.pasajes.stream()
				.mapToDouble(pasaje -> pasaje.getPromedioOcupacionEnPeriodo(vuelo, fechaInicio, fechaFin)).average()
				.orElse(0);
	}

	public double getHorasVoladasEnPeriodo(Avion avion, LocalDate fechaInicio, LocalDate fechaFin) {
		return this.pasajes.stream()
				.mapToDouble(pasaje -> pasaje.getHorasVoladasEnPeriodo(avion, fechaInicio, fechaFin)).sum();
	}

	public double getHorasVoladasEnTotal(Avion avion) {
		return this.pasajes.stream()
				.mapToDouble(pasaje -> pasaje.getHorasVoladasEnPeriodo(avion, LocalDate.MIN, LocalDate.MAX)).sum();
	}

	public double getMontoTotalDescuentos() {
		return this.pasajes.stream().mapToDouble(pasaje -> pasaje.getMontoDescuentos()).sum();
	}

	public double getEficienciaTarifas() {
		double facturado = this.pasajes.stream().mapToDouble(pasaje -> pasaje.getPrecio()).sum();
		double costoBase = this.pasajes.stream().mapToDouble(pasaje -> pasaje.getCostoBase()).sum();
		return facturado / costoBase;
	}
}
