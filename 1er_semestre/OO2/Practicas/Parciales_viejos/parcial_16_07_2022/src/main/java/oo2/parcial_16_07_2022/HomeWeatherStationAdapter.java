package oo2.parcial_16_07_2022;

import java.util.List;

public class HomeWeatherStationAdapter extends HomeWeather {
	private HomeWeatherStation adaptee;

	public HomeWeatherStationAdapter(HomeWeatherStation adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public double getTemperaturaCelsius() {
		return makeCelsius(this.adaptee.getTemperaturaFahrenheit());
	}

	@Override
	public double getTemperaturaFahrenheit() {
		return this.adaptee.getTemperaturaFahrenheit();
	}

	@Override
	public double getPresion() {
		return this.adaptee.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		return this.adaptee.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturasFahrenheit() {
		return this.adaptee.getTemperaturasFahrenheit();
	}

	@Override
	public double getPromedioTemperaturasFahrenheit() {
		return this.getTemperaturasFahrenheit().stream().mapToDouble(t -> t).average().orElse(0);
	}

	@Override
	public double getPromedioTemperaturasCelsius() {
		return makeCelsius(this.getPromedioTemperaturasFahrenheit());
	}

	@Override
	public String displayData() {
		return "";
	}

	private double makeCelsius(double fahrenheit) {
		return (fahrenheit - 32) / 1.8;
	}
}
