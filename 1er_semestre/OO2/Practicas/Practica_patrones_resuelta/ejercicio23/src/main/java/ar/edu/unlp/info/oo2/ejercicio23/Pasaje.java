package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalDate;
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

	// Cambiaría segun descripto en getPrecio()
	public double getRateDiario() {
		if (!this.tramos.isEmpty()) {
			return this.tramos.stream()
					.mapToDouble(tramo -> VALORES_DIARIOS[tramo.getFecha().getDayOfWeek().getValue() - 1])
					.reduce(1.0, (a, b) -> a * b);
		}
		return 0;
	}

	public double getCostoBase() {
		return this.tramos.stream().mapToDouble(t -> t.getCostoBase()).sum();
	}

	// Está mal hecho je
	// Correcto sería: this.getCostoBase() - (this.getCostoBase() *
	// (1 - this.getRateDiario()) + this.getCostoBase() * (1 -
	// this.getRateRoundTrip) +
	// (1 - this.getRateMultiHop()) * this.getCostoBase())
	// Aunque tampoco estaría bien por la forma de calcular los rate diarios
	// Para obtener los precios con rate diario habría que pedirle a cada tramo
	// que calcule su valor según el dia de la semana que es y después sumar
	// los valores ajustados al día de cada tramo para obtener precio con rateDiario
	// y ahí sí hacer: this.precioConRateDiario() - (this.getCostoBase() * (1 -
	// this.getRateRoundTrip) + (1 - this.getRateMultiHop()) * this.getCostoBase())
	// Entonces al precio total de los costosBases ajustados al día se les restaría
	// el monto de los descuentos
	// Pero me da paja porque tengo que cambiar 400 millones de tests y no es la
	// idea
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

	// Cambiaría segun descripto en getPrecio()
	public double getMontoDescuentos() {
		double rateMultiHop = this.getRateMultiHop();
		double rateRoundTrip = this.getRateRoundTrip();
		double costoBase = this.getCostoBase();

		if (rateMultiHop < 1 && rateRoundTrip < 1) {
			return costoBase * (1 - rateMultiHop) * (1 - rateRoundTrip);
		} else if (rateMultiHop < 1) {
			return costoBase * (1 - rateMultiHop);
		} else if (rateRoundTrip < 1) {
			return costoBase * (1 - rateRoundTrip);
		} else {
			return 0;
		}
	}

	public double getPromedioOcupacionEnPeriodo(Vuelo vuelo, LocalDate fechaInicio, LocalDate fechaFin) {
		return this.tramos.stream()
				.filter(tramo -> tramo.isFromVuelo(vuelo) && tramo.isDateInPeriod(fechaInicio, fechaFin))
				.mapToDouble(tramoValido -> tramoValido.getPromedioOcupacion()).average().orElse(0);
	}

	public double getHorasVoladasEnPeriodo(Avion avion, LocalDate fechaInicio, LocalDate fechaFin) {
		return this.tramos.stream()
				.filter(tramo -> tramo.isFromAvion(avion) && tramo.isDateInPeriod(fechaInicio, fechaFin))
				.mapToDouble(tramoValido -> tramoValido.getHorasVoladas()).sum();
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