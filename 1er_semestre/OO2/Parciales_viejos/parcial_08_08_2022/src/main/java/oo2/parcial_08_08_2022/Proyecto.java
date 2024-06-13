package oo2.parcial_08_08_2022;

import java.time.LocalDate;
import java.time.Period;

public class Proyecto {
	private LocalDate fechaInicio, fechaFin;
	private String nombre, objetivo;
	private int nroIntegrantes;
	private double montoFijoPorDia;
	private double margenGanancia;
	private ProyectoState state;

	public Proyecto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String objetivo, int nroIntegrantes,
			double montoFijoPorDia) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombre = nombre;
		this.objetivo = objetivo;
		this.nroIntegrantes = nroIntegrantes;
		this.montoFijoPorDia = montoFijoPorDia;
		this.margenGanancia = 0.07;
		this.state = new EnConstruccionState(this);
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setMargenGanancia(double margenGanancia) {
		this.margenGanancia = margenGanancia;
	}

	public void setState(ProyectoState state) {
		this.state = state;
	}

	public String getStateName() {
		return this.state.getNombre();
	}

	public void aprobarEtapa() throws Exception {
		this.state.aprobarEtapa();
	}

	public double costoProyecto() {
		return Period.between(fechaInicio, fechaFin).getDays() * this.montoFijoPorDia * this.nroIntegrantes;
	}

	public double precioProyecto() {
		return this.costoProyecto() * (1 + this.margenGanancia);
	}

	public void moficarMargenGanancia(double margenGanancia) {
		this.state.moficarMargenGanancia(margenGanancia);
	}

	public void cancelarProyecto() {
		this.state.cancelarProyecto();
	}

	public void appendToObjetivo(String string) {
		this.objetivo += string;
	}
}
