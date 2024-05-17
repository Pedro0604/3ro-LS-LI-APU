package ar.edu.unlp.info.oo2.ejercicio23;

import java.time.LocalTime;

public class TypeVuelo {
	private String id, ciudadSalida, ciudadLlegada;
	private LocalTime horaSalida, horaLlegada;
	private double costoBase;
	private boolean[] frecuencia;
	private Avion avion;

	public TypeVuelo(String id, String ciudadSalida, String ciudadLlegada, LocalTime horaSalida, LocalTime horaLlegada,
			double costoBase, boolean[] frecuencia, Avion avion) {
		this.id = id;
		this.ciudadSalida = ciudadSalida;
		this.ciudadLlegada = ciudadLlegada;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.costoBase = costoBase;
		this.frecuencia = frecuencia;
		this.avion = avion;
	}

	public String getId() {
		return id;
	}

	public String getCiudadSalida() {
		return ciudadSalida;
	}

	public String getCiudadLlegada() {
		return ciudadLlegada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}

	public double getCostoBase() {
		return costoBase;
	}

	public boolean[] getFrecuencia() {
		return frecuencia;
	}

	public Avion getAvion() {
		return avion;
	}
}
