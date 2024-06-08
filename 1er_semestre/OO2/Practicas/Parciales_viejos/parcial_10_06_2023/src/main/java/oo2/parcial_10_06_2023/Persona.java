package oo2.parcial_10_06_2023;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private String name;
	private int edad;
	private List<Vehiculo> vehiculos;
	private StrategyPromocion promocion;

	public Persona(String name, int edad) {
		this.name = name;
		this.edad = edad;
		this.promocion = promocion;
		this.vehiculos = new ArrayList<>();
	}

	public void setPromocion(StrategyPromocion promocion) {
		this.promocion = promocion;
	}

	public void addVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}

	public double getCantPolizas() {
		return this.vehiculos.size();
	}

	public double getCostoSeguros() {
		return this.getSumaSeguros() - this.promocion.getMontoDescuento();
	}

	public double getCostoSeguroMasEconomico() {
		return this.vehiculos.stream().mapToDouble(vehiculo -> vehiculo.getCostoSeguros(edad)).min().orElse(0.0);
	}

	public double getSumaSeguros() {
		return this.vehiculos.stream().mapToDouble(vehiculo -> vehiculo.getCostoSeguros(this.edad)).sum();
	}
}
