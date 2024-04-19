package ar.edu.unlp.info.oo2.ejercicio11;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Proyecto {
	@SuppressWarnings("unused")
	private String nombre, objetivo;
	private LocalDateTime fechaInicio, fechaFin;
	private int nroIntegrantes;
	private double montoPorDia, margenDeGanancia;
	private ProyectoState state;

	public Proyecto(String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin, String objetivo,
			int nroIntegrantes, double montoPorDia) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.objetivo = objetivo;
		this.nroIntegrantes = nroIntegrantes;
		this.montoPorDia = montoPorDia;
		this.margenDeGanancia = 0.07;
		this.state = new EnConstruccion(this);
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setMargenDeGanancia(double margenDeGanancia) {
		this.margenDeGanancia = margenDeGanancia;
	}

	public void setState(ProyectoState state) {
		this.state = state;
	}

	public void appendToObjetivo(String str) {
		this.objetivo += str;
	}

	public long getDiasProyecto() {
		return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
	}

	public void aprobarEtapa() {
		this.state.aprobarEtapa();
	}

	public double costoProyecto() {
		return this.nroIntegrantes * this.montoPorDia * this.getDiasProyecto();
	}

	public double precioProyecto() {
		return this.costoProyecto() * (1 + this.margenDeGanancia);
	}

	public void modificarMargenDeGanancia(double margenDeGanancia) {
		this.state.modificarMargenDeGanancia(margenDeGanancia);
	}

	public void cancelarProyecto() {
		this.state.cancelarProyecto();
	}

	public String getState() {
		return this.state.getNombre();
	}
}
