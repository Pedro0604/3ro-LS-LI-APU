package oo2.parcial_16_07_2022;

import java.util.List;

public class HomeWeatherStation {
	private double temperatura, presion, radiacionSolar;
	private List<Double> temperaturas;

	public HomeWeatherStation(double temperatura, double presion, double radiacionSolar, List<Double> temperaturas) {
		this.temperatura = temperatura;
		this.presion = presion;
		this.radiacionSolar = radiacionSolar;
		this.temperaturas = temperaturas;
	}

	public double getTemperaturaFahrenheit() {
		return temperatura;
	}

	public double getPresion() {
		return presion;
	}

	public double getRadiacionSolar() {
		return radiacionSolar;
	}

	public List<Double> getTemperaturasFahrenheit() {
		return temperaturas;
	}
}
