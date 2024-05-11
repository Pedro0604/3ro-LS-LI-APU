package ar.edu.unlp.info.oo2.ejercicio16;

import java.util.List;

public class HomeWheaterStation implements WheaterData {
	private double temperatura, presion, radiacionSolar;
	private List<Double> temperaturas;

	public HomeWheaterStation(double temperatura, double presion, double radiacionSolar, List<Double> temperaturas) {
		super();
		this.temperatura = temperatura;
		this.presion = presion;
		this.radiacionSolar = radiacionSolar;
		this.temperaturas = temperaturas;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public double getPresion() {
		return presion;
	}

	public double getRadiacionSolar() {
		return radiacionSolar;
	}

	public List<Double> getTemperaturas() {
		return temperaturas;
	}

	public String displayData() {
//		return "Temperatura F: " + this.getTemperatura() + "Presión atmosf: " + this.getPresion() + "Radiación solar: "
//				+ this.getRadiacionSolar();
		return "";
	}
}
