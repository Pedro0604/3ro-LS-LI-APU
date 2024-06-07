package oo2.parcial_16_07_2022.decorators;

import java.util.List;

import oo2.parcial_16_07_2022.HomeWeather;

public abstract class HomeWeatherDecorator extends HomeWeather {
	protected HomeWeather homeWeather;

	public HomeWeatherDecorator(HomeWeather homeWeather) {
		this.homeWeather = homeWeather;
	}

	@Override
	public double getTemperaturaCelsius() {
		return this.homeWeather.getTemperaturaCelsius();
	}

	@Override
	public double getTemperaturaFahrenheit() {
		return this.homeWeather.getTemperaturaFahrenheit();
	}

	@Override
	public double getPresion() {
		return this.homeWeather.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		return this.homeWeather.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturasFahrenheit() {
		return this.homeWeather.getTemperaturasFahrenheit();
	}

	@Override
	public double getPromedioTemperaturasFahrenheit() {
		return this.homeWeather.getPromedioTemperaturasFahrenheit();
	}

	@Override
	public double getPromedioTemperaturasCelsius() {
		return this.homeWeather.getPromedioTemperaturasCelsius();
	}

	@Override
	public String displayData() {
		return this.homeWeather.displayData() + " " + this.displayRealData();
	}

	protected abstract String displayRealData();
}
