package oo2.parcial_16_07_2022.decorators;

import oo2.parcial_16_07_2022.HomeWeather;

public class TemperaturaCelsiusDecorator extends HomeWeatherDecorator {
	public TemperaturaCelsiusDecorator(HomeWeather homeWeather) {
		super(homeWeather);
	}

	@Override
	protected String displayRealData() {
		return "Temperatura C: " + this.homeWeather.getTemperaturaCelsius() + "°";
	}
}