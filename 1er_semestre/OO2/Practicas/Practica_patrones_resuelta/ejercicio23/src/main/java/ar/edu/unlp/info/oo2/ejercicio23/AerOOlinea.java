package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalDate;
import java.util.List;

public class AerOOlinea {
	private List<Pasaje> pasajes;
	private List<Avion> aviones;
	private List<TypeVuelo> typeVuelos;
	private List<Vuelo> vuelos;

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

	public void addTypeVuelo(TypeVuelo typeVuelo) {
		this.typeVuelos.add(typeVuelo);
	}

	public void addAvion(Avion avion) {
		this.aviones.add(avion);
	}

	public double getPromedioOcupacionEnPeriodo(TypeVuelo vuelo, LocalDate inicio, LocalDate fin) {
		return -1;
	}

	public double getHorasVoladasEnPeriodo(Avion avion, LocalDate inicio, LocalDate fin) {
		return -1;
	}

	public double getHorasVoladasEnTotal(Avion avion) {
		return -1;
	}

	public double getMontoTotalDescuentos() {
		return -1;
	}

	public double getEficienciaTarifas() {
		return -1;
	}
}
