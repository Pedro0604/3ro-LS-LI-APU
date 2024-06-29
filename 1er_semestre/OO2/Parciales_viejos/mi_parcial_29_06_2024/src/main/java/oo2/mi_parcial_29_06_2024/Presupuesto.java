package oo2.mi_parcial_29_06_2024;

import java.time.LocalDate;

public class Presupuesto {
	private Equipo equipo;
	private String nombreComprador;
	private LocalDate fecha;

	public Presupuesto(String nombreComprador, Configuracion configuracion, Director director) {
		this.nombreComprador = nombreComprador;
		this.fecha = LocalDate.now();
		this.equipo = director.construir(configuracion);
	}

	public Equipo getEquipo() {
		return equipo;
	}
}
