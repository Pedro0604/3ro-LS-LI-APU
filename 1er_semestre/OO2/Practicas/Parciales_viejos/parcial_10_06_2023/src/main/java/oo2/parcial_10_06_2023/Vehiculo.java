package oo2.parcial_10_06_2023;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vehiculo {
	private double valor;
	private int anio;
	private Seguro seguro;
	private int capacidadMaxima;

	public Vehiculo(double valor, int anio, int capacidadMaxima) {
		super();
		this.valor = valor;
		this.anio = anio;
		this.seguro = seguro;
		this.capacidadMaxima = capacidadMaxima;
	}

	public double getValor() {
		return valor;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public long getAntiguedad() {
		return ChronoUnit.YEARS.between(LocalDate.of(anio, 1, 1), LocalDate.now());
	}

	public double getCostoSeguros(int edadAsegurado) {
		return this.seguro.getCosto(edadAsegurado);
	}
}
