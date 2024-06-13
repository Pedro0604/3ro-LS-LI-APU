package oo2.parcial_16_07_2022;

import java.util.List;

public abstract class HomeWeather {

	public abstract double getTemperaturaCelsius();

	public abstract double getTemperaturaFahrenheit();

	public abstract double getPresion();

	public abstract double getRadiacionSolar();

	public abstract List<Double> getTemperaturasFahrenheit();

	public abstract double getPromedioTemperaturasFahrenheit();

	public abstract double getPromedioTemperaturasCelsius();

	public abstract String displayData();
}
