package oo2.parcial_16_07_2022.decorators;

import oo2.parcial_16_07_2022.HomeWeather;

public class PromedioTemperaturasCelsius extends HomeWeatherDecorator {
	public PromedioTemperaturasCelsius(HomeWeather homeWeather) {
		super(homeWeather);
	}

	@Override
	protected String displayRealData() {
		return "Promedio de temperaturas C: " + this.homeWeather.getPromedioTemperaturasCelsius() + "°";
	}
}