package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalTime;

public class Vuelo {
	private String id, ciudadSalida, ciudadLlegada;
	private LocalTime horaSalida, horaLlegada;
	private double costoBase;
	private boolean[] frecuencia;

	public Vuelo(String id, String ciudadSalida, String ciudadLlegada, LocalTime horaSalida, LocalTime horaLlegada,
			double costoBase, boolean[] frecuencia) {
		this.id = id;
		this.ciudadSalida = ciudadSalida;
		this.ciudadLlegada = ciudadLlegada;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.costoBase = costoBase;
		this.frecuencia = frecuencia;
	}

	public String getCiudadSalida() {
		return ciudadSalida;
	}

	public String getCiudadLlegada() {
		return ciudadLlegada;
	}

	public double getCostoBase() {
		return costoBase;
	}

}
